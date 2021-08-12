package com.example.sep3t3demo.daoInterfaces;

import com.example.sep3t3demo.res.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();

    User findByUsername(String username);

}
