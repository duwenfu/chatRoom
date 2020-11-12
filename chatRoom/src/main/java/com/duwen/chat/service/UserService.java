package com.duwen.chat.service;

import com.duwen.chat.dto.User;

import java.util.List;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/11/12 18:44
 */
public interface UserService {

    String insert(User user);

    List<User> select();
}
