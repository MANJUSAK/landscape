package com.goodsoft.landscape.dao;

/**
 * function 文件管理访问数据dao接口类
 * Created by 严彬荣 on 2017/7/28.
 */
public interface FileManageDao {
    //查询文件
    public <T> T queryFileDao(String arg, Class c);

    //保存文件
    public void saveFileDao(Object var) throws Exception;

}
