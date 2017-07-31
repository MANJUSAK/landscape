package com.goodsoft.landscape.util.resulteutil;

/**
 * function 返回结果集实体（无文件）
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public class ResultTwo implements java.io.Serializable {

    private static final long serialVersionUID = 8484593320970244294L;
    // 状态码
    private int code;
    // 返回数据
    private Object data;

    public ResultTwo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ResultTwo(int code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
