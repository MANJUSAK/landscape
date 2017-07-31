package com.goodsoft.landscape.entity.device;

import javax.persistence.*;

/**
 * function 机械设备表实体类
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
@Entity
@Table(name = "gs_MechanicalEQ", catalog = "landscape")
public class MechanicalEQ implements java.io.Serializable {

    private static final long serialVersionUID = -5793096146969929351L;

    // 表ID
    private Integer mid;
    // 车牌号
    private String carId;
    // 发动机号
    private String engineId;
    // 车架号
    private String vin;
    // 入户时间
    private String registerDate;
    // 年审时间
    private String checkDate;
    // 保险时间
    private String insuranceDate;
    // 车属单位
    private String company;
    // 备注
    private String comment;
    // 数据状态参数
    private int isNo;
    private String uid;//用户id
    private Integer did;//行车记录表id

    public MechanicalEQ() {
        super();
        this.isNo = 0;
        // TODO Auto-generated constructor stub
    }

    public MechanicalEQ(Integer mid, String carId, String engineId,
                        String vin, String registerDate, String checkDate,
                        String insuranceDate, String company, String comment, int isNo) {
        super();
        this.mid = mid;
        this.carId = carId;
        this.engineId = engineId;
        this.vin = vin;
        this.registerDate = registerDate;
        this.checkDate = checkDate;
        this.insuranceDate = insuranceDate;
        this.company = company;
        this.comment = comment;
        this.isNo = isNo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid", nullable = false)
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer did) {
        this.mid = did;
    }

    @Column(name = "carId", nullable = false, length = 20)
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Column(name = "engineId", nullable = false, length = 20)
    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    @Column(name = "vin", nullable = false, length = 50)
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Column(name = "registerDate", nullable = false, length = 50)
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name = "checkDate", nullable = false, length = 50)
    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    @Column(name = "insuranceDate", nullable = false, length = 50)
    public String getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(String insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    @Column(name = "company", nullable = false, length = 150)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "comment", nullable = false, length = 1000)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
