package com.goodsoft.landscape.controller;

import com.goodsoft.landscape.entity.device.*;
import com.goodsoft.landscape.formfilter.DeviceFormFilter;
import com.goodsoft.landscape.service.DeviceManageService;
import com.goodsoft.landscape.util.resulteutil.PageUtil;
import com.goodsoft.landscape.util.resulteutil.Parameter;
import com.goodsoft.landscape.util.resulteutil.Status;
import com.goodsoft.landscape.util.resulteutil.StatusEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * function 设备管理访问入口Java类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("/device")
public class DeviceManageController {

    @Resource
    private DeviceManageService service;
    @Resource
    private DeviceFormFilter filter;

    /**
     * 功能：查询行车记录数据访问入口方法
     *
     * @return object对象
     * @parameter 无
     */
    @ResponseBody
    @RequestMapping(value = "/queryxcjl", produces = "application/json;charset=utf-8")
    public Object queryDrivingRecordController(PageUtil var, Parameter var1) {
        return this.service.queryService(var, var1, DrivingRecord.class);
    }

    /**
     * 功能：行车记录数据录入访问入口方法
     *
     * @return 数据录入提示信息status
     * @parameter msg 行车记录数据
     */
    @ResponseBody
    @RequestMapping(value = "/savexcjl", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Status saveDrivingRecordController(DrivingRecord msg) {
        return this.service.saveService(msg);
    }

    /**
     * 功能：查询机械设备数据访问入口方法
     *
     * @return object对象
     * @parameter 无
     */
    @ResponseBody
    @RequestMapping(value = "/queryjxsb", produces = "application/json;charset=utf-8")
    public Object queryMechanicalEQController(PageUtil var, Parameter var1) {
        return this.service.queryService(var, var1, MechanicalEQ.class);
    }

    /**
     * 功能：机械设备数据录入访问入口方法
     *
     * @return 数据录入提示信息status
     * @parameter msg 行车记录数据
     */
    @ResponseBody
    @RequestMapping(value = "/savejxsb", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Status saveMechanicalEQController(MechanicalEQ msg) {
        // 表单数据验证
        boolean tip = this.filter.MechanicalEQForm(msg);
        if (tip == false) {
            return new Status(StatusEnum.CHECK_DATA.getCODE(), StatusEnum.CHECK_DATA.getEXPLAIN());
        }
        return this.service.saveService(msg);
    }

    /**
     * 功能：查询耗油量数据访问入口方法
     *
     * @return object对象
     * @parameter 无
     */
    @ResponseBody
    @RequestMapping(value = "/queryhyl", produces = "application/json;charset=utf-8")
    public Object queryFuelConsumptionController(PageUtil var, Parameter var1) {
        return this.service.queryService(var, var1, FuelConsumption.class);
    }

    /**
     * 功能：耗油量数据录入访问入口方法
     *
     * @return 数据录入提示信息status
     * @parameter msg 行车记录数据
     */
    @ResponseBody
    @RequestMapping(value = "/savehyl", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Status saveFuelConsumptionController(FuelConsumption msg) {
        // 表单数据验证
       /* boolean tip = this.filter.MechanicalEQForm(msg);
        if (tip == false) {
            return new Status(StatusEnum.CHECK_DATA.getCODE(), StatusEnum.CHECK_DATA.getEXPLAIN());
        }*/
        return this.service.saveService(msg);
    }

    /**
     * 功能：查询维修情况数据访问入口方法
     *
     * @return object对象
     * @parameter var 分页参数，var1 用户参数
     */
    @ResponseBody
    @RequestMapping(value = "/querywxqk", produces = "application/json;charset=utf-8")
    public Object queryMaintenanceController(PageUtil var, Parameter var1) {
        return this.service.queryService(var, var1, Maintenance.class);
    }

    /**
     * 功能：维修情况数据录入访问入口方法
     *
     * @return 数据录入提示信息status
     * @parameter msg 行车记录数据
     */
    @ResponseBody
    @RequestMapping(value = "/savewxqk", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Status saveMaintenanceController(Maintenance msg) {
        // 表单数据验证
       /* boolean tip = this.filter.MechanicalEQForm(msg);
        if (tip == false) {
            return new Status(StatusEnum.CHECK_DATA.getCODE(), StatusEnum.CHECK_DATA.getEXPLAIN());
        }*/
        return this.service.saveService(msg);
    }

    /**
     * 功能：查询用车量数据访问入口方法
     *
     * @return object对象
     * @parameter 无
     */
    @ResponseBody
    @RequestMapping(value = "/queryycl", produces = "application/json;charset=utf-8")
    public Object queryUseVehicleNumController(PageUtil var, Parameter var1) {
        return this.service.queryService(var, var1, UseVehicleNum.class);
    }

    /**
     * 功能：用车量数据录入访问入口方法
     *
     * @return 数据录入提示信息status
     * @parameter msg 行车记录数据
     */
    @ResponseBody
    @RequestMapping(value = "/saveycl", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Status saveMaintenanceController(UseVehicleNum msg) {
        // 表单数据验证
       /* boolean tip = this.filter.MechanicalEQForm(msg);
        if (tip == false) {
            return new Status(StatusEnum.CHECK_DATA.getCODE(), StatusEnum.CHECK_DATA.getEXPLAIN());
        }*/
        return this.service.saveService(msg);
    }

    /**
     * 功能：查询用车量数据访问入口方法
     *
     * @return object对象
     * @parameter 无
     */
    @ResponseBody
    @RequestMapping(value = "/queryxcgls", produces = "application/json;charset=utf-8")
    public Object queryVehicleKMNumController(PageUtil var, Parameter var1) {
        return this.service.queryService(var, var1, VehicleKMNum.class);
    }

    /**
     * 功能：用车量数据录入访问入口方法
     *
     * @return 数据录入提示信息status
     * @parameter msg 行车记录数据
     */
    @ResponseBody
    @RequestMapping(value = "/savexcgls", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Status saveVehicleKMNumController(VehicleKMNum msg) {
        // 表单数据验证
       /* boolean tip = this.filter.MechanicalEQForm(msg);
        if (tip == false) {
            return new Status(StatusEnum.CHECK_DATA.getCODE(), StatusEnum.CHECK_DATA.getEXPLAIN());
        }*/
        return this.service.saveService(msg);
    }
}


