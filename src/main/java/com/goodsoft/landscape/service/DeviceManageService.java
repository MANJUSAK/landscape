package com.goodsoft.landscape.service;

import com.goodsoft.landscape.util.resulteutil.PageUtil;
import com.goodsoft.landscape.util.resulteutil.Parameter;
import com.goodsoft.landscape.util.resulteutil.Status;

/**
 * function 设备管理业务逻辑Java接口类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public interface DeviceManageService {

    // 查询设备管理数据业务接口
    public <T> T queryService(PageUtil var, Parameter var1, Class c);

    // 设备管理数据录入业务接口
    public Status saveService(Object msg);
}
