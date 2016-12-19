package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by BHWL on 2016-12-19.
 */
@Entity
public class Jiashu {
    private int id;
    private Integer laorenid;
    private String laorenname;
    private String name;
    private String telphone;
    private String mobile;
    private String guanxi;
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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telphone", nullable = true, length = 255)
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 255)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "guanxi", nullable = true, length = 255)
    public String getGuanxi() {
        return guanxi;
    }

    public void setGuanxi(String guanxi) {
        this.guanxi = guanxi;
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

        Jiashu jiashu = (Jiashu) o;

        if (id != jiashu.id) return false;
        if (laorenid != null ? !laorenid.equals(jiashu.laorenid) : jiashu.laorenid != null) return false;
        if (laorenname != null ? !laorenname.equals(jiashu.laorenname) : jiashu.laorenname != null) return false;
        if (name != null ? !name.equals(jiashu.name) : jiashu.name != null) return false;
        if (telphone != null ? !telphone.equals(jiashu.telphone) : jiashu.telphone != null) return false;
        if (mobile != null ? !mobile.equals(jiashu.mobile) : jiashu.mobile != null) return false;
        if (guanxi != null ? !guanxi.equals(jiashu.guanxi) : jiashu.guanxi != null) return false;
        if (createuser != null ? !createuser.equals(jiashu.createuser) : jiashu.createuser != null) return false;
        if (createusername != null ? !createusername.equals(jiashu.createusername) : jiashu.createusername != null) return false;
        if (createtime != null ? !createtime.equals(jiashu.createtime) : jiashu.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (laorenid != null ? laorenid.hashCode() : 0);
        result = 31 * result + (laorenname != null ? laorenname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telphone != null ? telphone.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (guanxi != null ? guanxi.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        result = 31 * result + (createusername != null ? createusername.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
