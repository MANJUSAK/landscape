package com.goodsoft.landscape.formfilter;

import com.goodsoft.landscape.entity.device.MechanicalEQ;

/**
 * function 设备管理表单过滤接口类
 * <p>
 * date 2017.06.20
 *
 * @author 严彬荣
 */
public interface DeviceFormFilter {
    //机械设备数据录入业务方法
    public boolean MechanicalEQForm(MechanicalEQ msg);
}
