package com.goodsoft.landscape.dao;

import com.goodsoft.landscape.entity.users.Grade;
import com.goodsoft.landscape.entity.users.Rights;
import com.goodsoft.landscape.entity.users.User;
import com.goodsoft.landscape.entity.users.UserInfo;

import java.util.List;

/**
 * function 用户管理访问数据库Java接口类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public interface UserManageDao {

    // 用户登录dao接口
    public UserInfo login(User user);

    // 检查用户名是否重复dao接口
    public boolean checkName(String name);

    // 检查手机号是否重复dao接口
    public boolean checkTel(String tel);

    // 用户注册dao接口
    public void register(User user) throws Exception;

    //初始化系统权限管理dao接口
    public void rightsInitialization(List<Rights> rights, List<Grade> grade) throws Exception;

    //检查系统权限数据是否存在（方式服务器重启再次初始化权限数据）dao接口
    public List queryRights();

    //初始化用户具有系统权限dao接口
    public Grade queryRightsById(int var);

}
