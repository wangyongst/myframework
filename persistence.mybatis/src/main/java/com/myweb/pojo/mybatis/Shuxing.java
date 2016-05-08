package com.myweb.pojo.mybatis;

public class Shuxing {
    private Integer id;

    private String type;

    private String chinesetype;

    private String name;

    private String remark;

    private Integer shunxu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getChinesetype() {
        return chinesetype;
    }

    public void setChinesetype(String chinesetype) {
        this.chinesetype = chinesetype == null ? null : chinesetype.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getShunxu() {
        return shunxu;
    }

    public void setShunxu(Integer shunxu) {
        this.shunxu = shunxu;
    }
}