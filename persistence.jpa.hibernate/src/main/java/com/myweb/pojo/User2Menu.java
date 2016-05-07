package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangy on 2016/5/8.
 */
@Entity
public class User2Menu {
    private int id;
    private Integer shuxingid;
    private Integer menuid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "shuxingid")
    public Integer getShuxingid() {
        return shuxingid;
    }

    public void setShuxingid(Integer shuxingid) {
        this.shuxingid = shuxingid;
    }

    @Basic
    @Column(name = "menuid")
    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User2Menu user2Menu = (User2Menu) o;

        if (id != user2Menu.id) return false;
        if (shuxingid != null ? !shuxingid.equals(user2Menu.shuxingid) : user2Menu.shuxingid != null) return false;
        if (menuid != null ? !menuid.equals(user2Menu.menuid) : user2Menu.menuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shuxingid != null ? shuxingid.hashCode() : 0);
        result = 31 * result + (menuid != null ? menuid.hashCode() : 0);
        return result;
    }
}
