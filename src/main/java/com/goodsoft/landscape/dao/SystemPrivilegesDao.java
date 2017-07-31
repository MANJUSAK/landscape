package com.goodsoft.landscape.dao;

import com.goodsoft.landscape.entity.users.Grade;

/**
 * function 系统权限管理操作数据库接口类
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
public interface SystemPrivilegesDao {

    //系统权限判断dao接口
    public Grade judgeRights(String var);
}
