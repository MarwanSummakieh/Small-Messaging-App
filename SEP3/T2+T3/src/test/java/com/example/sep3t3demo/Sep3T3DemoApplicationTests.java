package com.example.sep3t3demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@AutoConfigureMockRestServiceServer
@SpringBootTest
class Sep3T3DemoApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postUser() throws Exception {
        String mockUserJson = "{\"username\":\"test\",\"password\":\"test\",\"email\":\"test\"}";

        //Create a post request with an accept header for application\json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/sep3/postUser/")
                .accept(MediaType.APPLICATION_JSON).content(mockUserJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        //Assert that the return status is CREATED
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
