package com.goodsoft.landscape.util;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * function excel工具接口类
 * Created by 严彬荣 on 2017/7/27.
 */
public interface ExcelUtil {

    //创建excel表格
    public String writeExcel(HttpServletRequest request, List list, String excel) throws Exception;

}
