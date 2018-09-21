package com.minol.domain.entity;

import java.util.Date;

public class Core_User {
    private static final long serialVersionUID = 1L;

    private Integer pk_user_id;// 主键ID
    private Integer fk_model_id;// 模型表_主键ID
    private Integer fk_grade_id;// 级别表_主键ID
    private String username;// 用户名称
    private String email;// 邮箱
    private String mobile;// 手机
    private String password;// 密码
    private String salt;// 加密码
    private String state;// 状态(0:锁定 1:正常 2:待验证)
    private Date registerTime;// 注册时间
    private String registerIp;// 注册IP
    private String registerMode;// 注册方式(1:前台注册 2:后台添加 3:其它)
    private Date lastLoginTime;// 最后登录时间
    private String lastLoginIp;// 最后登录IP
    private Date currentLoginTime;// 当前登录时间
    private String currentLoginIp;// 当前登录IP
    private Integer loginCount;// 登录次数
    private Integer errorCount;// 错误次数
    private Date createDatetime;// 创建时间
    private Date updateDatetime;// 修改时间
    private String exattribute;// 备用字段

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPk_user_id() {
        return pk_user_id;
    }

    public void setPk_user_id(Integer pk_user_id) {
        this.pk_user_id = pk_user_id;
    }

    public Integer getFk_model_id() {
        return fk_model_id;
    }

    public void setFk_model_id(Integer fk_model_id) {
        this.fk_model_id = fk_model_id;
    }

    public Integer getFk_grade_id() {
        return fk_grade_id;
    }

    public void setFk_grade_id(Integer fk_grade_id) {
        this.fk_grade_id = fk_grade_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getCurrentLoginTime() {
        return currentLoginTime;
    }

    public void setCurrentLoginTime(Date currentLoginTime) {
        this.currentLoginTime = currentLoginTime;
    }

    public String getCurrentLoginIp() {
        return currentLoginIp;
    }

    public void setCurrentLoginIp(String currentLoginIp) {
        this.currentLoginIp = currentLoginIp;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getExattribute() {
        return exattribute;
    }

    public void setExattribute(String exattribute) {
        this.exattribute = exattribute;
    }
}
