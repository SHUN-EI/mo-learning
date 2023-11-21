package com.mo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by mo on 2023/11/21
 */
@Data
@ApiModel(description = "菜单实体")
public class Menu {

    @ApiModelProperty(value = "菜单id")
    private int id;
    @ApiModelProperty(value = "菜单名称")
    private String name;
}
