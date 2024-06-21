package com.his.controller;

import com.his.entity.Doctor;
import com.his.entity.Registinfo;
import com.his.io.FileIO;
import com.his.util.AlertUitl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class ConsultationViewController {
    @FXML
    private TextField txt_id;         //病历号
    @FXML
    private Label txt_realname ;    //患者姓名
    @FXML
    private Label txt_gender ;      //患者性别
    @FXML
    private Label txt_cardnumber ;  //身份证号
    @FXML
    private Label txt_age;           //年龄
    @FXML
    private TextArea txt_diagiosis;       //诊断结果
    @FXML
    private TextArea txt_prescription;    //处方开药（逗号分割）
    @FXML
    private TextField txt_drugprice;       //药品总价
    @FXML
    private Label txt_doctorname;       //看诊医生
    @FXML
    private Label txt_deptname;         //看诊科室
    @FXML
    private Label txt_registlevel;      //挂号级别
    @FXML
    private Label txt_registdate;       //看诊日期

    public static Stage primaryStage;   //当前主舞台对象（主功能界面的舞台）
    public static Doctor doctor;        //当前登录成功那个医生对象

    public static Stage consultStage;       //当前看诊舞台对象
    public TextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(TextField txt_id) {
        this.txt_id = txt_id;
    }

    public Label getTxt_realname() {
        return txt_realname;
    }

    public void setTxt_realname(Label txt_realname) {
        this.txt_realname = txt_realname;
    }

    public Label getTxt_gender() {
        return txt_gender;
    }

    public void setTxt_gender(Label txt_gender) {
        this.txt_gender = txt_gender;
    }

    public Label getTxt_cardnumber() {
        return txt_cardnumber;
    }

    public void setTxt_cardnumber(Label txt_cardnumber) {
        this.txt_cardnumber = txt_cardnumber;
    }

    public Label getTxt_age() {
        return txt_age;
    }

    public void setTxt_age(Label txt_age) {
        this.txt_age = txt_age;
    }

    public TextArea getTxt_diagiosis() {
        return txt_diagiosis;
    }

    public void setTxt_diagiosis(TextArea txt_diagiosis) {
        this.txt_diagiosis = txt_diagiosis;
    }

    public TextArea getTxt_prescription() {
        return txt_prescription;
    }

    public void setTxt_prescription(TextArea txt_prescription) {
        this.txt_prescription = txt_prescription;
    }

    public TextField getTxt_drugprice() {
        return txt_drugprice;
    }

    public void setTxt_drugprice(TextField txt_drugprice) {
        this.txt_drugprice = txt_drugprice;
    }

    public Label getTxt_doctorname() {
        return txt_doctorname;
    }

    public void setTxt_doctorname(Label txt_doctorname) {
        this.txt_doctorname = txt_doctorname;
    }

    public Label getTxt_deptname() {
        return txt_deptname;
    }

    public void setTxt_deptname(Label txt_deptname) {
        this.txt_deptname = txt_deptname;
    }

    public Label getTxt_registlevel() {
        return txt_registlevel;
    }

    public void setTxt_registlevel(Label txt_registlevel) {
        this.txt_registlevel = txt_registlevel;
    }

    public Label getTxt_registdate() {
        return txt_registdate;
    }

    public void setTxt_registdate(Label txt_registdate) {
        this.txt_registdate = txt_registdate;
    }

    /**
     * 查询病例
     */
    public void queryConsultation(){
        List<Registinfo> rlist = (List<Registinfo>)FileIO.readObject("registinfo.txt");
        boolean flag = true;
        for(Registinfo reg:rlist){
//            System.out.println(reg.getId());
//            System.out.println(reg.getDoctorname());
//            System.out.println(reg.getVisitstate());
            if(reg.getId() == Integer.parseInt(txt_id.getText()) && doctor.getRealname().equals(reg.getDoctorname()) && reg.getVisitstate() == 1){
                txt_realname.setText(reg.getRealname());
                txt_gender.setText(reg.getGender());
                txt_cardnumber.setText(reg.getCardnumber());
                txt_age.setText(reg.getAge()+"");
                txt_deptname.setText(reg.getDeptname());
                txt_doctorname.setText(reg.getDoctorname());
                txt_registlevel.setText(reg.getRegistlevel());
                txt_registdate.setText(reg.getRegistdate());
                flag = false;
                break;
            }
        }
        if(flag){
            AlertUitl.showAlert(primaryStage,"查询失败","没有当前要查询的病例","请填写正确的病历号");
            txt_realname.setText("");
            txt_gender.setText("");
            txt_cardnumber.setText("");
            txt_age.setText("");
            txt_deptname.setText("");
            txt_doctorname.setText("");
            txt_registlevel.setText("");
            txt_registdate.setText("");
        }
    }

    /**
     * 看诊和开药处方
     */
    public void addConsultation(){
        List<Registinfo> rlist = (List<Registinfo>)FileIO.readObject("registinfo.txt");
        Integer id = Integer.parseInt(txt_id.getText());

        for(Registinfo reg:rlist){
            if(reg.getId().intValue() == id.intValue() && doctor.getRealname().equals(reg.getDoctorname()) && reg.getVisitstate() == 1){
                System.out.println("helloworld");
               reg.setDiagiosis(txt_diagiosis.getText());
               reg.setPrescrption(txt_prescription.getText());
               reg.setDrugprice(Double.parseDouble(txt_drugprice.getText()));
               reg.setVisitstate(2);
                break;
            }
        }
        FileIO.writeObject("registinfo.txt",rlist);
        AlertUitl.showAlert(primaryStage,"看诊成功","患者"+txt_realname.getText()+"已经完成看诊","请患者到药房取药");
        consultStage.close();
    }
}
