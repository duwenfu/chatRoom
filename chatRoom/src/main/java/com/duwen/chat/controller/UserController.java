package com.duwen.chat.controller;

import com.duwen.chat.dto.User;
import com.duwen.chat.mapper.UserMapper;
import com.duwen.chat.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/11/12 18:45
 */
@Api
@RestController
@RequestMapping("/login")
public class UserController{

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @ApiOperation("用户注册")
    @RequestMapping("/tt")
    public void register(@RequestBody User user){
        userService.insert(user);
    }

    /**
     * 用户信息查询
     */
    @ResponseBody
    @RequestMapping("/get")
    public String get(){
        List<User> user = userService.select();
        user.toString();
        return "1";
    }
}
