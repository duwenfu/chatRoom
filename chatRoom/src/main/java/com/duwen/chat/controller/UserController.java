package com.duwen.chat.controller;

import com.duwen.chat.dto.User;
import com.duwen.chat.mapper.UserMapper;
import com.duwen.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/11/12 18:45
 */
@RestController
@RequestMapping("/login")
public class UserController{

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/tt")
    public void register(@RequestBody User user){
        userService.insert(user);
    }
}
