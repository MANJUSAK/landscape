package com.goodsoft.landscape.util.resulteutil;

/**
 * function 返回结果集实体（有文件）
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public class ResultOne implements java.io.Serializable {

    private static final long serialVersionUID = 1967397333105111758L;
    // 状态码
    private int code;
    // 服务器域名地址
    private String path;
    // 返回数据
    private Object data;

    public ResultOne() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ResultOne(int code, Object data) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
