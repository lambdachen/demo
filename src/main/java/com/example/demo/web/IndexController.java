package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chenliuyang on 2017-08-25.
 */
@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public List<User> user() {
        PageHelper.startPage(1, 3);
        List<User> userList = userService.listUser();
        System.out.println(userList);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println(pageInfo.getPages());
        List<User> userList1 = userService.listUser();
        return userList;
    }

    @RequestMapping("/add/{name}")
    public String addUser(@PathVariable String name) {
        int id = userService.insertUser(name);
        return String.valueOf(id);
    }

    @ExceptionHandler({RuntimeException.class})
    public String excep() {
        return "occurred a exception";
    }
}
