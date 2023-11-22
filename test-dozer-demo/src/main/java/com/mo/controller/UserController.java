package com.mo.controller;

import com.mo.dozer.DozerUtils;
import com.mo.dto.UserDTO;
import com.mo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by mo on 2023/11/22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DozerUtils dozerUtils;

    @GetMapping("/mapper")
    public UserDTO mapper() {

        UserEntity userEntity = new UserEntity();
        userEntity.setId("10");
        userEntity.setName("tom");
        userEntity.setAge(20);
        userEntity.setAddress("shenzhen");
        userEntity.setBirthday(new Date());

        UserDTO userDTO = dozerUtils.map(userEntity, UserDTO.class,"user");

        return userDTO;

    }

}
