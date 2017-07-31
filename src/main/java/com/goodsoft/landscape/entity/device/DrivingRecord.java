package com.goodsoft.landscape.entity.device;

import javax.persistence.*;

/**
 * function 行车记录表实体类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@Entity
@Table(name = "gs_drivingRecord", catalog = "landscape")
public class DrivingRecord implements java.io.Serializable {
    //表id
    private Integer did;
    //司机名字
    private String driverName;
    //工作起点
    private String wkStartingPoint;
    //工作终点
    private String wkEnd;
    //车牌号
    private String carId;
    //工作时间
    private String workTime;
    private String uid;//用户id
    //状态参数
    private int isNo;

    public DrivingRecord() {
        this.isNo = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did", nullable = false)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Column(name = "driverName", nullable = false, length = 30)
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Column(name = "wkStartingPoint", nullable = false, length = 150)
    public String getWkStartingPoint() {
        return wkStartingPoint;
    }

    public void setWkStartingPoint(String wkStartingPoint) {
        this.wkStartingPoint = wkStartingPoint;
    }

    @Column(name = "wkEnd", nullable = false, length = 150)
    public String getWkEnd() {
        return wkEnd;
    }

    public void setWkEnd(String wkEnd) {
        this.wkEnd = wkEnd;
    }

    @Column(name = "carId", nullable = false, length = 20)
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Column(name = "workTime", nullable = false, length = 50)
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Column(name = "uid", nullable = false, length = 32)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Column(name = "isNo", nullable = false)
    public int getIsNo() {
        return isNo;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }
}
