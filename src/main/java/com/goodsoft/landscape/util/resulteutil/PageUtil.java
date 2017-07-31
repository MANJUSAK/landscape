package com.goodsoft.landscape.util.resulteutil;

/**
 * function 分页辅助类
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
public class PageUtil implements java.io.Serializable {

    private int page;//页数
    private int num;//总条数

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
