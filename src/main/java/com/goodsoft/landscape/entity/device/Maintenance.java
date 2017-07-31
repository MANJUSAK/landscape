package com.goodsoft.landscape.entity.device;

import javax.persistence.*;

/**
 * function 维修情况表实体类
 * <p>
 * Created by 严彬荣 on 2017/7/24.
 */
@Entity
@Table(name = "gs_maintenance", catalog = "landscape")
public class Maintenance implements java.io.Serializable {
    private Integer mid;//表ID
    private String engine;//发动机系统
    private String turns;//转动系统
    private String toTurnTo;//转向系统
    private String braking;//制动系统
    private String driving;//行驶系统
    private String appearance;//外观系统
    private String other;//其它
    private int isNo;//状态参数
    private String uid;//用户id
    private Integer did;//行车记录表id

    public Maintenance() {
        this.isNo = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid", nullable = false)
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Column(name = "engine", length = 3000)
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Column(name = "turns", length = 3000)
    public String getTurns() {
        return turns;
    }

    public void setTurns(String turns) {
        this.turns = turns;
    }

    @Column(name = "toTurnTo", length = 3000)
    public String getToTurnTo() {
        return toTurnTo;
    }

    public void setToTurnTo(String toTurnTo) {
        this.toTurnTo = toTurnTo;
    }

    @Column(name = "braking", length = 3000)
    public String getBraking() {
        return braking;
    }

    public void setBraking(String braking) {
        this.braking = braking;
    }

    @Column(name = "driving", length = 3000)
    public String getDriving() {
        return driving;
    }

    public void setDriving(String driving) {
        this.driving = driving;
    }

    @Column(name = "appearance", length = 3000)
    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    @Column(name = "other", length = 3000)
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Column(name = "isNo", nullable = false)
    public int getIsNo() {
        return isNo;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }

    @Column(name = "uid", nullable = false, length = 32)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Column(name = "did", nullable = false)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}
