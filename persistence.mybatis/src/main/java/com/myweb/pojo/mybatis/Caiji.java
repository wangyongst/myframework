package com.myweb.pojo.mybatis;

import java.math.BigDecimal;

public class Caiji {
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLaorenid() {
        return laorenid;
    }

    public void setLaorenid(Integer laorenid) {
        this.laorenid = laorenid;
    }

    public String getLaorenname() {
        return laorenname;
    }

    public void setLaorenname(String laorenname) {
        this.laorenname = laorenname == null ? null : laorenname.trim();
    }

    public Integer getGaoya() {
        return gaoya;
    }

    public void setGaoya(Integer gaoya) {
        this.gaoya = gaoya;
    }

    public Integer getDiya() {
        return diya;
    }

    public void setDiya(Integer diya) {
        this.diya = diya;
    }

    public BigDecimal getXuetang() {
        return xuetang;
    }

    public void setXuetang(BigDecimal xuetang) {
        this.xuetang = xuetang;
    }

    public Integer getMaibo() {
        return maibo;
    }

    public void setMaibo(Integer maibo) {
        this.maibo = maibo;
    }

    public Integer getXueyang() {
        return xueyang;
    }

    public void setXueyang(Integer xueyang) {
        this.xueyang = xueyang;
    }

    public BigDecimal getTizhong() {
        return tizhong;
    }

    public void setTizhong(BigDecimal tizhong) {
        this.tizhong = tizhong;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername == null ? null : createusername.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}