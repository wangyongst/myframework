package com.myweb.pojo.mybatis;

public class User {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private Integer createuser;

    private String createusername;

    private String createtime;

    private Integer shuxingroleid;

    private String shuxingrolename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    public Integer getShuxingroleid() {
        return shuxingroleid;
    }

    public void setShuxingroleid(Integer shuxingroleid) {
        this.shuxingroleid = shuxingroleid;
    }

    public String getShuxingrolename() {
        return shuxingrolename;
    }

    public void setShuxingrolename(String shuxingrolename) {
        this.shuxingrolename = shuxingrolename == null ? null : shuxingrolename.trim();
    }
}