package com.his.entity;

import java.io.Serializable;

/**
 * 医生信息的实体类
 */
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;          //医生编号（登录账号）
    private String realname;    //医生姓名
    private String password;    //密码
    private String deptname;    //所在科室
    private String registlevel; //挂号级别:普通和专家，主任医师，副主任医生。。。。
    private Double registfee;   //挂号费用

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getRegistlevel() {
        return registlevel;
    }

    public void setRegistlevel(String registlevel) {
        this.registlevel = registlevel;
    }

    public Double getRegistfee() {
        return registfee;
    }

    public void setRegistfee(Double registfee) {
        this.registfee = registfee;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", deptname='" + deptname + '\'' +
                ", registlevel='" + registlevel + '\'' +
                ", registfee=" + registfee +
                '}';
    }
}
