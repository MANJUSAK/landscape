package com.goodsoft.landscape.util.resulteutil;

/**
 * function 状态信息提示返回结果集实体
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public class Status implements java.io.Serializable {
    private int code;
    private String mag;

    public Status(int code, String mag) {
        this.code = code;
        this.mag = mag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }
}
