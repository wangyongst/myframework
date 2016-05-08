package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangy on 2016/5/8.
 */
@Entity
public class Shuxing {
    private int id;
    private String type;
    private String chinesetype;
    private String name;
    private String remark;
    private Integer shunxu;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "chinesetype", nullable = true, length = 255)
    public String getChinesetype() {
        return chinesetype;
    }

    public void setChinesetype(String chinesetype) {
        this.chinesetype = chinesetype;
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
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "shunxu", nullable = true)
    public Integer getShunxu() {
        return shunxu;
    }

    public void setShunxu(Integer shunxu) {
        this.shunxu = shunxu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shuxing shuxing = (Shuxing) o;

        if (id != shuxing.id) return false;
        if (type != null ? !type.equals(shuxing.type) : shuxing.type != null) return false;
        if (chinesetype != null ? !chinesetype.equals(shuxing.chinesetype) : shuxing.chinesetype != null) return false;
        if (name != null ? !name.equals(shuxing.name) : shuxing.name != null) return false;
        if (remark != null ? !remark.equals(shuxing.remark) : shuxing.remark != null) return false;
        if (shunxu != null ? !shunxu.equals(shuxing.shunxu) : shuxing.shunxu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (chinesetype != null ? chinesetype.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (shunxu != null ? shunxu.hashCode() : 0);
        return result;
    }
}
