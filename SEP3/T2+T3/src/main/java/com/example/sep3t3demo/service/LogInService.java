package com.example.sep3t3demo.service;

import com.example.sep3t3demo.logIn.LogInDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService implements ILoginService {
    @Autowired
    private LogInDaoImp loginDao;
    @Override
    public boolean userAuthentication(String username, String password) {
        return loginDao.userAuthentication(username, password);
    }
}
