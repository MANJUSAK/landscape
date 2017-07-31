package com.goodsoft.landscape.service;

import com.goodsoft.landscape.entity.users.User;
import com.goodsoft.landscape.util.resulteutil.Status;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function 用户管理业务逻辑处理Java接口类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public interface UserManageServie {
    // 用户登陆
    public <T> T login(User user, HttpServletRequest request);

    // 用户注册
    public Status register(MultipartFile files, User user, HttpServletRequest request);

    //初始化系统权限管理接口
    public boolean rightsInitialization();

    //检查系统权限数据是否存在（方式服务器重启再次初始化权限数据）接口
    public boolean queryRights();
}
