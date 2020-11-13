package com.du.chat.service.impl;

import com.du.chat.service.UserService;
import com.du.chat.dto.User;
import com.du.chat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/11/12 18:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @author duwen.fu
     * @param user 用户
     */
    @Override
    public void insert(User user){
         userMapper.register(user);
    }

    /**
     * 查询用户
     * @author duwen.fu
     * @return List<User>
     */
    @Override
    public List<User> select(){
        return userMapper.select();
    }
}
