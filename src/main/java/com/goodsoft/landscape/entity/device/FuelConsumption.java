package com.goodsoft.landscape.entity.device;

import javax.persistence.*;

/**
 * function 耗油量表实体
 * <p>
 * Created by 严彬荣 on 2017/7/24.
 */
@Entity
@Table(name = "gs_fuelConsumption", catalog = "landscape")
public class FuelConsumption implements java.io.Serializable {
    private Integer fid;//表id
    private String invoiceId;//发票号码
    private String dates;//日期
    private String oilName;//油名称
    private String specifications;//规格
    private double num;//数量
    private String recipient;//领料人
    private String checking;//复核人
    private int isNo;//状态参数
    private String uid;//用户id
    private Integer did;//行车记录表id

    public FuelConsumption() {
        this.isNo=0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fid", nullable = false)
    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Column(name = "invoiceId", nullable = false, length = 50)
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Column(name = "dates", nullable = false, length = 50)
    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    @Column(name = "oilName", nullable = false, length = 30)
    public String getOilName() {
        return oilName;
    }

    public void setOilName(String oilName) {
        this.oilName = oilName;
    }

    @Column(name = "specifications", nullable = false, length = 300)
    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    @Column(name = "num", precision = 22, scale = 6, nullable = false)
    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Column(name = "recipient", nullable = false, length = 30)
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Column(name = "checking", nullable = false, length = 30)
    public String getChecking() {
        return checking;
    }

    public void setChecking(String checking) {
        this.checking = checking;
    }

    @Column(name = "uid", nullable = false,length = 32)
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

    @Column(name = "isNo", nullable = false)
    public int getIsNo() {
        return isNo;
    }


    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }
}
