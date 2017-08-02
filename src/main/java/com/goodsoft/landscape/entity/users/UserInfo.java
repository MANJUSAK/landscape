package com.goodsoft.landscape.entity.users;

/**
 * function 用户登录返回信息
 * Created by 严彬荣 on 2017/8/2.
 */
public class UserInfo {
    //用户编号
    private String uid;
    //权限表id
    private String roleId;
    // 用户名
    private String userName;
    // 手机号
    private String tel;
    // 头像
    private String head;
    //注册时间
    private String dates;

    public UserInfo() {
    }

    public UserInfo(String uid, String roleId, String userName, String tel, String head, String dates) {
        this.uid = uid;
        this.roleId = roleId;
        this.userName = userName;
        this.tel = tel;
        this.head = head;
        this.dates = dates;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }
}
