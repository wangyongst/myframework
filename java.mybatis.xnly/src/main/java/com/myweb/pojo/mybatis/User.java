package com.myweb.pojo.mybatis;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.createuser
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    private Integer createuser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.createusername
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    private String createusername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.role
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    private String role;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.createtime
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    private String createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.createuser
     *
     * @return the value of user.createuser
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public Integer getCreateuser() {
        return createuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.createuser
     *
     * @param createuser the value for user.createuser
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.createusername
     *
     * @return the value of user.createusername
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public String getCreateusername() {
        return createusername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.createusername
     *
     * @param createusername the value for user.createusername
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public void setCreateusername(String createusername) {
        this.createusername = createusername == null ? null : createusername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.role
     *
     * @return the value of user.role
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.role
     *
     * @param role the value for user.role
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.createtime
     *
     * @return the value of user.createtime
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.createtime
     *
     * @param createtime the value for user.createtime
     *
     * @mbg.generated Tue Dec 06 17:33:18 CST 2016
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}