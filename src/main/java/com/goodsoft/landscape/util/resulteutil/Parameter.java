package com.goodsoft.landscape.util.resulteutil;

/**
 * function 参数辅助类
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
public class Parameter implements java.io.Serializable {
    private String uid;//用户编号
    private String roleId;//用户权限编号
    private int did;//行车记录编号
    private String types;//excel文件类型
    private String id;//表id
    private String excel;//excel表名

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExcel() {
        return excel;
    }

    public void setExcel(String excel) {
        this.excel = excel;
    }
}
