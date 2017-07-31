package com.goodsoft.landscape.dao;

import java.util.List;

/**
 * function 设备管理访问数据库Java接口类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public interface DeviceManageDao {

    // 查询设备管理（有分页）数据dao接口
    public List queryDao(int page, int num, String id, Class t);

    //查询设备管理数据dao接口
    public List queryDao(String id, Class t);

    // 设备管理数据录入dao接口
    public void saveDao(Object msg) throws Exception;
}
