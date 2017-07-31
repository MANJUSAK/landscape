package com.goodsoft.landscape.controller;

import com.goodsoft.landscape.entity.users.User;
import com.goodsoft.landscape.formfilter.UserFormFilter;
import com.goodsoft.landscape.service.UserManageServie;
import com.goodsoft.landscape.util.resulteutil.Status;
import com.goodsoft.landscape.util.resulteutil.StatusEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 用户管理访问入口Java类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@Controller
public class UserManageController {

    @Resource
    private UserManageServie service;
    @Resource
    private UserFormFilter filter;

    /*
     * 功能：用户登录访问入口方法
     *
     * @parameter user 用户信息、request http请求
     *
     * @return 用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/login", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Object loginController(User user, HttpServletRequest request) {
        // 实现表单数据过滤
        boolean tip = this.filter.loginForm(user);
        if (tip == false) {
            return new Status(StatusEnum.LOGIN_DEFEAT.getCODE(), StatusEnum.LOGIN_DEFEAT.getEXPLAIN());
        }
        return this.service.login(user, request);
    }

    /*
     * 功能：用户注册访问入口方法
     *
     * parameter user 用户信息、files 用户头像文件、request http请求
     *
     * @return 注册提示信息
     */
    @ResponseBody
    @RequestMapping(value = "/register", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Status registerController(@RequestParam("files") MultipartFile files, User user, HttpServletRequest request) {
        // 实现表单数据过滤
        boolean tip = this.filter.registerForm(user);
        if (tip == false) {
            return new Status(StatusEnum.CHECK_DATA.getCODE(), StatusEnum.CHECK_DATA.getEXPLAIN());
        }
        return this.service.register(files, user, request);
    }
}
