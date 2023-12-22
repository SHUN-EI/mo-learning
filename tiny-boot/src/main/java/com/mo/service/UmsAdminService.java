package com.mo.service;

import com.mo.domain.AdminUserDetails;

/**
 * Created by mo on 2023/12/21
 * 后台用于管理Service
 */
public interface UmsAdminService {

    /**
     *  根据用户名获取用户信息
     * @param username
     * @return
     */
    AdminUserDetails getAdminByUsername(String username);

    /**
     * 用户名密码登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

}
