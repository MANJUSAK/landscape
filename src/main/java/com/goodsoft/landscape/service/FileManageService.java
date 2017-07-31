package com.goodsoft.landscape.service;

import javax.servlet.http.HttpServletRequest;

/**
 * function 文件管理业务逻辑处理接口类
 * <p>
 * Created by 严彬荣 on 2017/7/28.
 */
public interface FileManageService {
    //文件查询
    public <T> T queryFileService(String arg, HttpServletRequest request, Class c);

    //文件保存
    public boolean saveFileService(Object var);
}
