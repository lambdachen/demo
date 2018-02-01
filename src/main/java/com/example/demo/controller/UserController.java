package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by chenliuyang on 2017-08-25.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> user() {
        PageHelper.startPage(1, 3);
        List<User> userList = userService.listUser();
        System.out.println(userList);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println(pageInfo.getPages());
        List<User> userList1 = userService.listUser();
        return userList;
    }

    @RequestMapping(value = "/add/{name}", method = RequestMethod.GET)
    public String addUser(@PathVariable String name) {
        int id = userService.insertUser(name);
        return String.valueOf(id);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String addUser(MultipartFile files) {
        return "success";
    }

    @ExceptionHandler({RuntimeException.class})
    public String exception() {
        return "occurred a exception";
    }
}
