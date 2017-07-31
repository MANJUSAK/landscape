package com.goodsoft.landscape.formfilter;

import com.goodsoft.landscape.entity.users.User;

/**
 * function 用户管理表单过滤接口类
 * <p>
 * date 2017.06.20
 *
 * @author 严彬荣
 */
public interface UserFormFilter {
    //用户登录表单验证
    public boolean loginForm(User user);

    //用户注册表单验证
    public boolean registerForm(User user);
}
