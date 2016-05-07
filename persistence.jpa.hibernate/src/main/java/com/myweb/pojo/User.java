package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangy on 2016/5/8.
 */
@Entity
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private Integer createuser;
    private String createusername;
    private String createtime;
    private Integer shuxingroleid;
    private String shuxingrolename;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Basic
    @Column(name = "shuxingroleid")
    public Integer getShuxingroleid() {
        return shuxingroleid;
    }

    public void setShuxingroleid(Integer shuxingroleid) {
        this.shuxingroleid = shuxingroleid;
    }

    @Basic
    @Column(name = "shuxingrolename")
    public String getShuxingrolename() {
        return shuxingrolename;
    }

    public void setShuxingrolename(String shuxingrolename) {
        this.shuxingrolename = shuxingrolename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (createuser != null ? !createuser.equals(user.createuser) : user.createuser != null) return false;
        if (createusername != null ? !createusername.equals(user.createusername) : user.createusername != null)
            return false;
        if (createtime != null ? !createtime.equals(user.createtime) : user.createtime != null) return false;
        if (shuxingroleid != null ? !shuxingroleid.equals(user.shuxingroleid) : user.shuxingroleid != null)
            return false;
        if (shuxingrolename != null ? !shuxingrolename.equals(user.shuxingrolename) : user.shuxingrolename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        result = 31 * result + (createusername != null ? createusername.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (shuxingroleid != null ? shuxingroleid.hashCode() : 0);
        result = 31 * result + (shuxingrolename != null ? shuxingrolename.hashCode() : 0);
        return result;
    }
}
