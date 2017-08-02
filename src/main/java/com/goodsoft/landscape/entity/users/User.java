package com.goodsoft.landscape.entity.users;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * function 用户信息表实体
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@Entity
@Table(name = "gs_users", catalog = "landscape")
public class User implements java.io.Serializable {
    private static final long serialVersionUID = -4848779748009521896L;
    // 表id
    private Integer id;
    //用户编号
    private String uid;
    //权限表id
    private String roleId;
    // 用户名
    private String userName;
    // 用户密码
    private String passWord;
    // 手机号
    private String tel;
    // 头像
    private String head;
    //注册时间
    private String dates;
    //初始用户权限等级
    private int level;
    // 数据状态参数
    private int isNo;

    public User() {
        super();
        this.level = 0;
        this.isNo = 0;
        this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // TODO Auto-generated constructor stub
    }

    public User(Integer id) {
        super();
        this.id = id;
    }

    public User(String uid, String roleId, String userName, String tel, String head, String dates) {
        this.uid = uid;
        this.roleId = roleId;
        this.userName = userName;
        this.tel = tel;
        this.head = head;
        this.dates = dates;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "roleId", nullable = false, length = 32)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }


    @Column(name = "uid", unique = true, nullable = false, length = 32)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Column(name = "userName", unique = true, length = 30, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "passWord", length = 28, nullable = false)
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Column(name = "tel", unique = true, length = 20, nullable = false)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "head", length = 80, nullable = true)
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }


    @Column(name = "isNo", nullable = false)
    public int getIsNo() {
        return isNo;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }

    @Column(name = "dates", nullable = false, length = 30)
    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    @Transient
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

