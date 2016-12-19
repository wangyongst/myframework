package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by BHWL on 2016-12-19.
 */
@Entity
public class Fuwu {
    private int id;
    private Integer laorenid;
    private String laorenname;
    private String xiangmu;
    private String shuoming;
    private String time;
    private String fuwutype;
    private Integer createuser;
    private String createusername;
    private String createtime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "laorenid", nullable = true)
    public Integer getLaorenid() {
        return laorenid;
    }

    public void setLaorenid(Integer laorenid) {
        this.laorenid = laorenid;
    }

    @Basic
    @Column(name = "laorenname", nullable = true, length = 255)
    public String getLaorenname() {
        return laorenname;
    }

    public void setLaorenname(String laorenname) {
        this.laorenname = laorenname;
    }

    @Basic
    @Column(name = "xiangmu", nullable = true, length = 255)
    public String getXiangmu() {
        return xiangmu;
    }

    public void setXiangmu(String xiangmu) {
        this.xiangmu = xiangmu;
    }

    @Basic
    @Column(name = "shuoming", nullable = true, length = 255)
    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }

    @Basic
    @Column(name = "time", nullable = true, length = 255)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "fuwutype", nullable = true, length = 255)
    public String getFuwutype() {
        return fuwutype;
    }

    public void setFuwutype(String fuwutype) {
        this.fuwutype = fuwutype;
    }

    @Basic
    @Column(name = "createuser", nullable = true)
    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    @Basic
    @Column(name = "createusername", nullable = true, length = 255)
    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername;
    }

    @Basic
    @Column(name = "createtime", nullable = true, length = 255)
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

        Fuwu fuwu = (Fuwu) o;

        if (id != fuwu.id) return false;
        if (laorenid != null ? !laorenid.equals(fuwu.laorenid) : fuwu.laorenid != null) return false;
        if (laorenname != null ? !laorenname.equals(fuwu.laorenname) : fuwu.laorenname != null) return false;
        if (xiangmu != null ? !xiangmu.equals(fuwu.xiangmu) : fuwu.xiangmu != null) return false;
        if (shuoming != null ? !shuoming.equals(fuwu.shuoming) : fuwu.shuoming != null) return false;
        if (time != null ? !time.equals(fuwu.time) : fuwu.time != null) return false;
        if (fuwutype != null ? !fuwutype.equals(fuwu.fuwutype) : fuwu.fuwutype != null) return false;
        if (createuser != null ? !createuser.equals(fuwu.createuser) : fuwu.createuser != null) return false;
        if (createusername != null ? !createusername.equals(fuwu.createusername) : fuwu.createusername != null) return false;
        if (createtime != null ? !createtime.equals(fuwu.createtime) : fuwu.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (laorenid != null ? laorenid.hashCode() : 0);
        result = 31 * result + (laorenname != null ? laorenname.hashCode() : 0);
        result = 31 * result + (xiangmu != null ? xiangmu.hashCode() : 0);
        result = 31 * result + (shuoming != null ? shuoming.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (fuwutype != null ? fuwutype.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        result = 31 * result + (createusername != null ? createusername.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
