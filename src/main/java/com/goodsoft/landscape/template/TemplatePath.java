package com.goodsoft.landscape.template;

/**
 * function 获取模板文件路径工具类
 * Created by 严彬荣 on 2017/7/28.
 */
public class TemplatePath {
    /**
     * 创建本类的单例模式（具体说明参见util包下UUIDUtil类）
     */
    private volatile static TemplatePath instance;

    private TemplatePath() {
    }

    public static TemplatePath getInstance() {
        if (instance == null) {
            synchronized (TemplatePath.class) {
                if (instance == null)
                    instance = new TemplatePath();
            }
        }
        return instance;
    }

    /**
     * 获取本包资源路径
     *
     * @return 资源路径
     * @parameter 无
     */
    public StringBuilder getTemplatePath() {
        return new StringBuilder(this.getClass().getResource("").getPath());
    }
}
