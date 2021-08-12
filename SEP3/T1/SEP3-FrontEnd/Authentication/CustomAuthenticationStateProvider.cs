﻿using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.JSInterop;
using SEP3_FrontEnd.Data;
using SEP3_FrontEnd.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Text.Json;
using System.Threading.Tasks;

namespace SEP3_FrontEnd.Authentication
{
    public class CustomAuthenticationStateProvider : AuthenticationStateProvider
    {
        private readonly IJSRuntime jsRuntime;
        private readonly IUserService IuserService;


        private User cachedUser;

        public CustomAuthenticationStateProvider(IJSRuntime jsRuntime, IUserService IuserService)
        {
            this.jsRuntime = jsRuntime;
            this.IuserService = IuserService;
        }


        public async Task ValidateLogin(string username, string password)
        {
            Console.WriteLine("Validating log in");
            if (string.IsNullOrEmpty(username)) throw new Exception("Enter username");
            if (string.IsNullOrEmpty(password)) throw new Exception("Enter password");
            ClaimsIdentity identity = new ClaimsIdentity();
            try
            {
                User user = await IuserService.ValidateUser(username, password);
                identity = SetupClaimsForUser(user);
                string serialisedData = JsonSerializer.Serialize(user);
                await jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", serialisedData);
                cachedUser = user;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }

            NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(new ClaimsPrincipal(identity))));
        }


        private ClaimsIdentity SetupClaimsForUser(User user)
        {
            List<Claim> claims = new List<Claim>();
            claims.Add(new Claim("Level", user.SecurityLevel.ToString()));

            ClaimsIdentity identity = new ClaimsIdentity(claims, "apiauth_type");
            return identity;
        }


        public override async Task<AuthenticationState> GetAuthenticationStateAsync()
        {
            var identity = new ClaimsIdentity();
            if (cachedUser == null)
            {
                string userAsJson = await jsRuntime.InvokeAsync<string>("sessionStorage.getItem", "currentUser");
                if (!string.IsNullOrEmpty(userAsJson))
                {
                    User tmp = JsonSerializer.Deserialize<User>(userAsJson);
                }
            }
            else
            {
                identity = SetupClaimsForUser(cachedUser);
            }

            ClaimsPrincipal cachedClaimsPrincipal = new ClaimsPrincipal(identity);
            return await Task.FromResult(new AuthenticationState(cachedClaimsPrincipal));
        }

        public async Task Logout()
        {
            cachedUser = null;
            var user = new ClaimsPrincipal(new ClaimsIdentity());
           await jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", "");
            NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(user)));
        }

      
    }
}
