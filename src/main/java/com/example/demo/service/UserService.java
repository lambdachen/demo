package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ChenLY on 2017-09-12.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Transactional
    public Integer insertUser(String name) {
        User user = new User();
        user.setName(name);
        int result = userMapper.insertUser(user);
//        result = 1/0;
        return user.getId();
    }

}
