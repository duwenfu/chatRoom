package com.duwen.chat.mapper;

import com.duwen.chat.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/11/12 18:42
 */
@Mapper
public interface UserMapper {

    /**
     * 用户注册
     * @author duwen.fu
     * @param user
     */
    void register(@Param("user") User user);
}
