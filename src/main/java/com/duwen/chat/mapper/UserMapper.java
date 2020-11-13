package com.duwen.chat.mapper;

import com.duwen.chat.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/11/12 18:42
 */
@Repository
public interface UserMapper {

    /**
     * 用户注册
     * @author duwen.fu
     * @param user
     */
    void register(@Param("user") User user);

    /**
     * 用户查询
     * @return
     */
    List<User> select();
}
