package com.goodsoft.landscape.entity.file;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * function excel文件保存实体类
 * <p>
 * Created by 严彬荣 on 2017/7/28.
 */
@Entity
@Table(name = "gs_excelFile", catalog = "landscape")
public class ExcelFile implements java.io.Serializable {
    private Integer fid;//表id
    private String path;//路径
    private String uid;//用户编号
    private String types;//表格类型
    private String dates;//创建时间
    private int isNo;//状态参数

    public ExcelFile() {
        this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        this.isNo = 0;
    }

    public ExcelFile(String path, String types) {
        this.path = path;
        this.types = types;
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

    @Column(name = "path", nullable = false, unique = true, length = 150)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "uid", nullable = false, length = 32)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Column(name = "types", nullable = false, length = 20)
    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Column(name = "isNo", nullable = false)
    public int getIsNo() {
        return isNo;
    }

    @Column(name = "dates", nullable = false, length = 20)
    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }
}
