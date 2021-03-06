package com.goodsoft.landscape.util.resulteutil;

/**
 * function 系统响应状态提示枚举类
 * <p>
 * Created by 严彬荣 on 2017/7/24.
 */
public enum StatusEnum implements java.io.Serializable {
    SUCCESS(0, "成功"),
    SERVER_ERROR(500, "服务器繁忙"),
    UNKONW_ERROR(501, "未知错误"),
    ERROR(502, "错误操作"),
    NO_DATA(404, "无记录数据"),
    LOGIN_DEFEAT(406, "用户名与密码不匹配"),
    NAME_EXIST(402, "用户名已存在"),
    TEL_EXIST(403, "手机号已被使用"),
    NO_RIGHTS(401, "该用户无法操作此功能"),
    CHECK_DATA(407, "请正确填写信息后重试"),
    FILE_UPLOAD(600, "文件上传失败，请重试"),
    FILE_SIZE(601, "文件大小不符合要求"),
    FILE_FORMAT(603, "文件格式不正确");

    private final int CODE;
    private final String EXPLAIN;

    StatusEnum(int CODE, String EXPLAIN) {
        this.CODE = CODE;
        this.EXPLAIN = EXPLAIN;
    }

    public int getCODE() {
        return CODE;
    }

    public String getEXPLAIN() {
        return EXPLAIN;
    }
}
