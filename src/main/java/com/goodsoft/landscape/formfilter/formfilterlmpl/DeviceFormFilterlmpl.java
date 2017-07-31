package com.goodsoft.landscape.formfilter.formfilterlmpl;

import com.goodsoft.landscape.entity.device.MechanicalEQ;
import com.goodsoft.landscape.formfilter.DeviceFormFilter;
import org.springframework.stereotype.Service;

/**
 * function 设备管理表单过滤类
 * <p>
 * date 2017.06.20
 *
 * @author 严彬荣
 */
@Service
public class DeviceFormFilterlmpl implements DeviceFormFilter {

    /*
     * 功能 ：机械设备表单验证
     *
     * @parameter msg 机械设备数据信息
     *
     * @return Boolean值
     */
    public boolean MechanicalEQForm(MechanicalEQ msg) {
        // 判断字段是否为空
        if (msg.getCarId() == null || msg.getCheckDate() == null
                || msg.getComment() == null || msg.getCompany() == null
                || msg.getEngineId() == null || msg.getInsuranceDate() == null
                || msg.getRegisterDate() == null || msg.getVin() == null) {
            return false;
        }
        // 判断数据是否有效
        if (msg.getCarId().length() < 1 || msg.getCarId().length() > 20) {
            return false;
        } else if (msg.getCheckDate().length() < 1
                || msg.getCheckDate().length() > 50) {
            return false;
        } else if (msg.getComment().length() > 1000) {
            return false;
        } else if (msg.getCompany().length() < 1
                || msg.getCompany().length() > 150) {
            return false;
        } else if (msg.getEngineId().length() < 1
                || msg.getEngineId().length() > 20) {
            return false;
        } else if (msg.getInsuranceDate().length() < 1
                || msg.getInsuranceDate().length() > 50) {
            return false;
        } else if (msg.getRegisterDate().length() < 1
                || msg.getRegisterDate().length() > 50) {
            return false;
        } else if (msg.getVin().length() < 1 || msg.getVin().length() > 50) {
            return false;
        } else {
            return true;
        }
    }
}
