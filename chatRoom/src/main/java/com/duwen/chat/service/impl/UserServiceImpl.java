package com.duwen.chat.service.impl;

import com.duwen.chat.dto.User;
import com.duwen.chat.mapper.UserMapper;
import com.duwen.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/11/12 18:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void insert(User user){
        userMapper.register(user);
    }
}
