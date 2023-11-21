package com.mo.controller.user;

import com.mo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2023/11/21
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户控制器")
public class UserController {

    @GetMapping("/getAllUsers")
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户信息")
    public List<User> getAllUsers() {

        User user = new User();
        user.setId(10);
        user.setName("tony");
        user.setAge(20);
        user.setAddress("shenzhen");

        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }


    @PostMapping("/save")
    @ApiOperation(value = "新增用户", notes = "新增用户信息")
    public String save(@RequestBody User user) {
        return "新增用户成功";
    }


    @PutMapping("/update")
    @ApiOperation(value = "修改用户", notes = "修改用户信息")
    public String update(@RequestBody User user) {
        return "修改用户信息成功";
    }


    @DeleteMapping("/deleteById")
    @ApiOperation(value = "删除用户", notes = "删除用户信息")
    public String deleteById(int id) {
        return "删除用户信息成功";
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码",
                    required = true, type = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数",
                    required = true, type = "Integer")
    })
    @GetMapping("/page/{pageNum}/{pageSize}")
    @ApiOperation(value = "分页查询用户信息")
    public String findByPage(@PathVariable Integer pageNum,
                             @PathVariable Integer pageSize) {
        return "分页查询用户信息成功";
    }

}
