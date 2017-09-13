package com.example.demo.mapper;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ChenLY on 2017-09-12.
 */
@Repository
public interface UserMapper {

    List<User> listUser();

    Integer insertUser(User user);
}
