package com.goodsoft.landscape.controller;

import com.goodsoft.landscape.entity.device.DrivingRecord;
import com.goodsoft.landscape.entity.device.MechanicalEQ;
import com.goodsoft.landscape.service.FileDownload;
import com.goodsoft.landscape.util.resulteutil.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 文件下载访问入口类
 * Created by 严彬荣 on 2017/7/27.
 */
@Controller
@RequestMapping("/download")
public class FileDownloadController {

    @Resource
    private FileDownload service;

    /**
     * 机械设备excel导出并下载访问入口
     *
     * @return 导出excel下载地址
     * @parameter uid 用户编号，roleId 权限编号，types excel表类型，excel excel表名，id 数据库对应表id
     */
    @ResponseBody
    @RequestMapping(value = "/excel/mechanical", produces = "application/json;charset=utf-8", method = {RequestMethod.GET})
    public Object mechanicalDownload(HttpServletRequest request, Parameter var) {
        return this.service.exceldownload(request, var, MechanicalEQ.class);
    }

    /**
     * 行车记录excel导出并下载访问入口
     *
     * @return 导出excel下载地址
     * @parameter uid 用户编号，roleId 权限编号，types excel表类型，excel excel表名，id 数据库对应表id
     */
    @ResponseBody
    @RequestMapping(value = "/excel/drive", produces = "application/json;charset=utf-8", method = {RequestMethod.GET})
    public Object driveDownload(HttpServletRequest request, Parameter var) {
        return this.service.exceldownload(request, var, DrivingRecord.class);
    }
}
