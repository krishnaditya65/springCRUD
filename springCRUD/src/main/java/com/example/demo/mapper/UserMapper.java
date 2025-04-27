package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.MyUser;

public class UserMapper {

    public static UserDTO toDTO(MyUser user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());
        return dto;
    }

    public static MyUser toEntity(UserDTO dto) {
        if (dto == null) return null;

        MyUser user = new MyUser();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        return user;
    }
}
