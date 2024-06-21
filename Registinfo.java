package com.his.entity;

import java.io.Serializable;

/**
 * 挂号和病例信息的实体类
 */
public class Registinfo implements Serializable {
    private Integer id;             //病历号(自动生成)
    private String realname;        //患者姓名
    private String gender;          //患者性别
    private String cardnumber;      //患者身份证号
    private String birthdate;       //出生年月
    private Integer age;            //年龄
    private String homeaddress;     //家庭住址
    private String deptname;        //挂号科室
    private String doctorname;      //挂号医生
    private String registlevel;     //挂号级别
    private String isbook;          //是否需要病历本
    private Double registfee;       //挂号费
    private String registdate;      //挂号日期
    private String diagiosis;       //诊断结果
    private String prescrption;     //开药处方
    private Double drugprice;       //开药总价
    private int visitstate;         //看诊状态（1.已挂号，2.已看诊，3.已取药（看诊结束））

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    @Override
    public String toString() {
        return "Registinfo{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", gender='" + gender + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", age=" + age +
                ", homeaddress='" + homeaddress + '\'' +
                ", deptname='" + deptname + '\'' +
                ", doctorname='" + doctorname + '\'' +
                ", registlevel='" + registlevel + '\'' +
                ", isbook='" + isbook + '\'' +
                ", registfee=" + registfee +
                ", registdate='" + registdate + '\'' +
                ", diagiosis='" + diagiosis + '\'' +
                ", prescrption='" + prescrption + '\'' +
                ", drugprice=" + drugprice +
                ", visitstate=" + visitstate +
                '}';
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getRegistlevel() {
        return registlevel;
    }

    public void setRegistlevel(String registlevel) {
        this.registlevel = registlevel;
    }

    public String getIsbook() {
        return isbook;
    }

    public void setIsbook(String isbook) {
        this.isbook = isbook;
    }

    public Double getRegistfee() {
        return registfee;
    }

    public void setRegistfee(Double registfee) {
        this.registfee = registfee;
    }

    public String getRegistdate() {
        return registdate;
    }

    public void setRegistdate(String registdate) {
        this.registdate = registdate;
    }

    public String getDiagiosis() {
        return diagiosis;
    }

    public void setDiagiosis(String diagiosis) {
        this.diagiosis = diagiosis;
    }

    public String getPrescrption() {
        return prescrption;
    }

    public void setPrescrption(String prescrption) {
        this.prescrption = prescrption;
    }

    public Double getDrugprice() {
        return drugprice;
    }

    public void setDrugprice(Double drugprice) {
        this.drugprice = drugprice;
    }

    public int getVisitstate() {
        return visitstate;
    }

    public void setVisitstate(int visitstate) {
        this.visitstate = visitstate;
    }
}
