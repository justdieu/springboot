package com.example.demo.model.mapper;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;

public class UserMapper {
    public static UserDto toUserdto( User user){
        UserDto tmp = new UserDto();
        tmp.setUser(user.getUser());
        tmp.setId(user.getId());
        tmp.setEmail(user.getEmail());
        tmp.setAvatar(user.getAvatar());
        tmp.setPhone(user.getPhone());
        return tmp;
    }
}
