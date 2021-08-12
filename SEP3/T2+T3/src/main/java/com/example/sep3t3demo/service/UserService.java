package com.example.sep3t3demo.service;

import com.example.sep3t3demo.res.User;
import com.example.sep3t3demo.daoInterfaces.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao dao;

    public List<User> findAll(){
        return dao.findAll();
    }
    public void postUser(User user){
        dao.save(user);
    }

    public User getUserByUsername(String username) {
        User user = dao.findByUsername(username);

        return user;
    }
}
