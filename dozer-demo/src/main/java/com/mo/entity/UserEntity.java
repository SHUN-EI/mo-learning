package com.mo.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by mo on 2023/11/22
 */
@Data
public class UserEntity {

    private String id;
    private String name;
    private int age;
    private String address;
    private Date birthday;
}
