package com.goodsoft.landscape.service;


import com.goodsoft.landscape.util.resulteutil.Parameter;

import javax.servlet.http.HttpServletRequest;

/**
 * function 文件下载业务逻辑处理接口类
 * Created by 严彬荣 on 2017/7/27.
 */
public interface FileDownload {
    //excel文件下载
    public <T> T exceldownload(HttpServletRequest request, Parameter var, Class c);
}
