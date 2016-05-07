package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by wangy on 2016/5/8.
 */
@Entity
public class Caiji {
    private int id;
    private Integer laorenid;
    private String laorenname;
    private Integer gaoya;
    private Integer diya;
    private BigDecimal xuetang;
    private Integer maibo;
    private Integer xueyang;
    private BigDecimal tizhong;
    private String time;
    private Integer createuser;
    private String createusername;
    private String createtime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "laorenid")
    public Integer getLaorenid() {
        return laorenid;
    }

    public void setLaorenid(Integer laorenid) {
        this.laorenid = laorenid;
    }

    @Basic
    @Column(name = "laorenname")
    public String getLaorenname() {
        return laorenname;
    }

    public void setLaorenname(String laorenname) {
        this.laorenname = laorenname;
    }

    @Basic
    @Column(name = "gaoya")
    public Integer getGaoya() {
        return gaoya;
    }

    public void setGaoya(Integer gaoya) {
        this.gaoya = gaoya;
    }

    @Basic
    @Column(name = "diya")
    public Integer getDiya() {
        return diya;
    }

    public void setDiya(Integer diya) {
        this.diya = diya;
    }

    @Basic
    @Column(name = "xuetang")
    public BigDecimal getXuetang() {
        return xuetang;
    }

    public void setXuetang(BigDecimal xuetang) {
        this.xuetang = xuetang;
    }

    @Basic
    @Column(name = "maibo")
    public Integer getMaibo() {
        return maibo;
    }

    public void setMaibo(Integer maibo) {
        this.maibo = maibo;
    }

    @Basic
    @Column(name = "xueyang")
    public Integer getXueyang() {
        return xueyang;
    }

    public void setXueyang(Integer xueyang) {
        this.xueyang = xueyang;
    }

    @Basic
    @Column(name = "tizhong")
    public BigDecimal getTizhong() {
        return tizhong;
    }

    public void setTizhong(BigDecimal tizhong) {
        this.tizhong = tizhong;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "createuser")
    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    @Basic
    @Column(name = "createusername")
    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername;
    }

    @Basic
    @Column(name = "createtime")
    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Caiji caiji = (Caiji) o;

        if (id != caiji.id) return false;
        if (laorenid != null ? !laorenid.equals(caiji.laorenid) : caiji.laorenid != null) return false;
        if (laorenname != null ? !laorenname.equals(caiji.laorenname) : caiji.laorenname != null) return false;
        if (gaoya != null ? !gaoya.equals(caiji.gaoya) : caiji.gaoya != null) return false;
        if (diya != null ? !diya.equals(caiji.diya) : caiji.diya != null) return false;
        if (xuetang != null ? !xuetang.equals(caiji.xuetang) : caiji.xuetang != null) return false;
        if (maibo != null ? !maibo.equals(caiji.maibo) : caiji.maibo != null) return false;
        if (xueyang != null ? !xueyang.equals(caiji.xueyang) : caiji.xueyang != null) return false;
        if (tizhong != null ? !tizhong.equals(caiji.tizhong) : caiji.tizhong != null) return false;
        if (time != null ? !time.equals(caiji.time) : caiji.time != null) return false;
        if (createuser != null ? !createuser.equals(caiji.createuser) : caiji.createuser != null) return false;
        if (createusername != null ? !createusername.equals(caiji.createusername) : caiji.createusername != null)
            return false;
        if (createtime != null ? !createtime.equals(caiji.createtime) : caiji.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (laorenid != null ? laorenid.hashCode() : 0);
        result = 31 * result + (laorenname != null ? laorenname.hashCode() : 0);
        result = 31 * result + (gaoya != null ? gaoya.hashCode() : 0);
        result = 31 * result + (diya != null ? diya.hashCode() : 0);
        result = 31 * result + (xuetang != null ? xuetang.hashCode() : 0);
        result = 31 * result + (maibo != null ? maibo.hashCode() : 0);
        result = 31 * result + (xueyang != null ? xueyang.hashCode() : 0);
        result = 31 * result + (tizhong != null ? tizhong.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        result = 31 * result + (createusername != null ? createusername.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
