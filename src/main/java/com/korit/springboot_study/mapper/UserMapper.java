package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectByUsername(String username);
    User selectById(int userId);
    int insert(User user);
}
