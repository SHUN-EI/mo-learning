package com.mo.controller.menu;

import com.mo.entity.Menu;
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
@RequestMapping("/menu")
@Api(tags = "菜单控制器")
public class MenuController {

    @GetMapping("/getMenus")
    @ApiOperation(value = "查询所有菜单", notes = "查询所有菜单信息")
    public List<Menu> getMenus() {
        Menu menu = new Menu();
        menu.setId(10);
        menu.setName("bill");
        List<Menu> menus = new ArrayList<>();
        menus.add(menu);

        return menus;
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增菜单", notes = "新增菜单信息")
    public String save(@RequestBody Menu menu) {
        return "新增菜单成功";
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改菜单", notes = "修改菜单信息")
    public String update(@RequestBody Menu menu) {
        return "修改菜单成功";
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "删除菜单", notes = "删除菜单信息")
    public String deleteById(int id) {
        return "删除菜单成功";
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码",
                    required = true, type = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数",
                    required = true, type = "Integer")
    })
    @GetMapping("/page/{pageNum}/{pageSize}")
    @ApiOperation(value = "分页查询菜单信息")
    public String findByPage(@PathVariable Integer pageNum,
                             @PathVariable Integer pageSize) {
        return "分页查询菜单信息成功";
    }
}
