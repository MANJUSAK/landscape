package com.goodsoft.landscape.entity.device;

import javax.persistence.*;

/**
 * function 行车公里数
 * <p>
 * Created by 严彬荣 on 2017/7/24.
 */
@Entity
@Table(name = "gs_vehicleKMNum", catalog = "landscape")
public class VehicleKMNum implements java.io.Serializable {
    private Integer vid;//表id
    private String driverName;//驾驶员
    private String carId;//车牌号
    private String mold;//类型
    private double kilometre;//公里数
    private int isNo;//状态参数
    private String uid;//用户id
    private Integer did;//行车记录表id

    public VehicleKMNum() {
        this.isNo = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vid", nullable = false)
    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    @Column(name = "driverName", length = 30, nullable = false)
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Column(name = "carId", length = 20, nullable = false)
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Column(name = "mold", length = 10, nullable = false)
    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }

    @Column(name = "kilometre", nullable = false)
    public double getKilometre() {
        return kilometre;
    }

    public void setKilometre(double kilometre) {
        this.kilometre = kilometre;
    }


    @Column(name = "isNo", nullable = false)
    public int getIsNo() {
        return isNo;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }

    @Column(name = "uid", length = 32, nullable = false)
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
