package com.his.controller;


import com.his.entity.Doctor;
import com.his.entity.Registinfo;
import com.his.io.FileIO;
import com.his.util.AlertUitl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class AddRegistViewController implements Initializable {
    //患者信息绑定属性
    @FXML
    private TextField txt_id;                   //病历号
    @FXML
    private TextField txt_realname;             //患者姓名
    @FXML
    private RadioButton txt_gender_man;         //男
    @FXML
    private RadioButton txt_gender_woman;       //女
    @FXML
    private TextField txt_age;                  //年龄
    @FXML
    private DatePicker txt_birthdate;           //出生年月
    @FXML
    private TextField txt_cardnumber;
    @FXML
    private TextField txt_homeaddress;

    //挂号信息
    @FXML
    private ComboBox<String> txt_deptname;
    @FXML
    private ComboBox<String> txt_registlevel;
    @FXML
    private ComboBox<String> txt_doctorname;
    @FXML
    private CheckBox txt_isbook;
    @FXML
    private DatePicker txt_registdate;

    //收费信息
    @FXML
    private Label txt_registfee;
    @FXML
    private TextField txt_receipts; //实际收费
    @FXML
    private Label txt_change;
    @FXML
    private Label txt_optioner ;    //挂号员 guahao
    @FXML
    private ToggleGroup toggleGroup = new ToggleGroup();

    public static Stage registStage;        //用来获取当前挂号舞台对象

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

    public void setToggleGroup(ToggleGroup toggleGroup) {
        this.toggleGroup = toggleGroup;
    }

    public TextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(TextField txt_id) {
        this.txt_id = txt_id;
    }

    public TextField getTxt_realname() {
        return txt_realname;
    }

    public void setTxt_realname(TextField txt_realname) {
        this.txt_realname = txt_realname;
    }

    public RadioButton getTxt_gender_man() {
        return txt_gender_man;
    }

    public void setTxt_gender_man(RadioButton txt_gender_man) {
        this.txt_gender_man = txt_gender_man;
    }

    public RadioButton getTxt_gender_woman() {
        return txt_gender_woman;
    }

    public void setTxt_gender_woman(RadioButton txt_gender_woman) {
        this.txt_gender_woman = txt_gender_woman;
    }

    public TextField getTxt_age() {
        return txt_age;
    }

    public void setTxt_age(TextField txt_age) {
        this.txt_age = txt_age;
    }

    public DatePicker getTxt_birthdate() {
        return txt_birthdate;
    }

    public void setTxt_birthdate(DatePicker txt_birthdate) {
        this.txt_birthdate = txt_birthdate;
    }

    public TextField getTxt_cardnumber() {
        return txt_cardnumber;
    }

    public void setTxt_cardnumber(TextField txt_cardnumber) {
        this.txt_cardnumber = txt_cardnumber;
    }

    public TextField getTxt_homeaddress() {
        return txt_homeaddress;
    }

    public void setTxt_homeaddress(TextField txt_homeaddress) {
        this.txt_homeaddress = txt_homeaddress;
    }

    public ComboBox<String> getTxt_deptname() {
        return txt_deptname;
    }

    public void setTxt_deptname(ComboBox<String> txt_deptname) {
        this.txt_deptname = txt_deptname;
    }

    public ComboBox<String> getTxt_registlevel() {
        return txt_registlevel;
    }

    public void setTxt_registlevel(ComboBox<String> txt_registlevel) {
        this.txt_registlevel = txt_registlevel;
    }

    public ComboBox<String> getTxt_doctorname() {
        return txt_doctorname;
    }

    public void setTxt_doctorname(ComboBox<String> txt_doctorname) {
        this.txt_doctorname = txt_doctorname;
    }

    public CheckBox getTxt_isbook() {
        return txt_isbook;
    }

    public void setTxt_isbook(CheckBox txt_isbook) {
        this.txt_isbook = txt_isbook;
    }

    public DatePicker getTxt_registdate() {
        return txt_registdate;
    }

    public void setTxt_registdate(DatePicker txt_registdate) {
        this.txt_registdate = txt_registdate;
    }

    public Label getTxt_registfee() {
        return txt_registfee;
    }

    public void setTxt_registfee(Label txt_registfee) {
        this.txt_registfee = txt_registfee;
    }

    public TextField getTxt_receipts() {
        return txt_receipts;
    }

    public void setTxt_receipts(TextField txt_receipts) {
        this.txt_receipts = txt_receipts;
    }

    public Label getTxt_change() {
        return txt_change;
    }

    public void setTxt_change(Label txt_change) {
        this.txt_change = txt_change;
    }

    public Label getTxt_optioner() {
        return txt_optioner;
    }

    public void setTxt_optioner(Label txt_optioner) {
        this.txt_optioner = txt_optioner;
    }



    /**
     * 挂号按钮绑定函数
     */
    public void addRegist(){
        List<Registinfo> rlist = (List<Registinfo>)FileIO.readObject("registinfo.txt");
        Registinfo registinfo = new Registinfo();
        registinfo.setId(Integer.parseInt(txt_id.getText()));
        registinfo.setRealname(txt_realname.getText());
        RadioButton select =(RadioButton) toggleGroup.getSelectedToggle();  //性别是从单选按钮组中来做的
        registinfo.setGender(select.getText());
        registinfo.setCardnumber(txt_cardnumber.getText());
        registinfo.setBirthdate(txt_birthdate.getValue().toString());
        registinfo.setAge(Integer.parseInt(txt_age.getText()));
        registinfo.setHomeaddress(txt_homeaddress.getText());
        registinfo.setDeptname(txt_deptname.getValue());
        registinfo.setRegistlevel(txt_registlevel.getValue());
        registinfo.setDoctorname(txt_doctorname.getValue());
        if(txt_isbook.isSelected()){
            registinfo.setIsbook("病历本");
        }
        registinfo.setRegistfee(Double.parseDouble(txt_registfee.getText()));
        registinfo.setRegistdate(txt_registdate.getValue().toString());
        registinfo.setVisitstate(1);

        rlist.add(registinfo);
        FileIO.writeObject("registinfo.txt",rlist);
        AlertUitl.showAlert(MainViewController.primaryStage,"挂号成功","患者"+registinfo.getRealname()+"在"+registinfo.getDeptname()+"挂号成功！","请通知患者及时就诊");
        registStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //病历号自动生成的功能
        int id = 100001;
        List<Registinfo> rlist = (List<Registinfo>)FileIO.readObject("registinfo.txt");
        List<Doctor> dlist = (List<Doctor>)FileIO.readObject("doctor.txt");
        if(rlist.size()>0){
            id = rlist.get(rlist.size()-1).getId()+1;
        }
        txt_id.setText(id+"");
        //科室初始化功能
        Set<String> dSet = new HashSet<String>();
        for(Doctor d:dlist){
           dSet.add( d.getDeptname());
        }
        for(String dname:dSet){
            txt_deptname.getItems().add(dname);
        }
        //设置科室下拉列表的监听器，监听科室内容的变化。一旦有变化，立刻影响号别列表的数据内容
        txt_deptname.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                txt_registlevel.setItems(FXCollections.observableArrayList());      //每次显示之前清空号别里面的数据
                Set<String> dSet = new HashSet<String>();
                for(Doctor d: dlist){
                   if(d.getDeptname().equals(newValue)){
                       dSet.add(d.getRegistlevel());
                   }
                }
                for(String registlevel:dSet){
                    txt_registlevel.getItems().add(registlevel);
                }
            }
        });

        //设置号别下拉列表监听器，监听号别列表中的数据，一旦号别数据变化，立刻影响医生列表的数据内容
        txt_registlevel.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                txt_doctorname.setItems(FXCollections.observableArrayList());      //每次显示之前清空号别里面的数据
                Set<String> dSet = new HashSet<String>();
                for(Doctor d: dlist){
                    if(d.getDeptname().equals(txt_deptname.getValue()) && d.getRegistlevel().equals(newValue)){
                        dSet.add(d.getRealname());
                    }
                }
                for(String realname:dSet){
                    txt_doctorname.getItems().add(realname);
                }
            }
        });
        txt_registfee.setText("0.00");
        txt_change.setText("0.00");
        //设置医生名字监听器，只要名字发生变化。立刻影响挂号费Label的变化
        txt_doctorname.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                for(Doctor d: dlist){
                    if(d.getDeptname().equals(txt_deptname.getValue()) && d.getRegistlevel().equals(txt_registlevel.getValue()) && d.getRealname().equals(newValue)){
                       txt_registfee.setText(d.getRegistfee()+"");
                       break;
                    }
                }

            }
        });
        //计算找零的功能
        txt_receipts.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                txt_change.setText("0.00");
                if(!newValue.equals("")){
                    double registfee = Double.parseDouble(txt_registfee.getText());  //12.00元
                    double receipts = Double.parseDouble(txt_receipts.getText());
                    if(receipts>=registfee){
                        DecimalFormat df = new DecimalFormat("#.00");
                        double number = receipts - registfee;
                        String str = df.format(number);
                        txt_change.setText(str);
                    }
                }

            }
        });
        //添加一个病历本的监听器，监听病历本的复选框是否选中，如果选中，挂号费会自动+1元
        txt_isbook.selectedProperty().addListener((obs,wasSelected,isNowSelect)->{
            if(isNowSelect){
                Double registfee = Double.parseDouble(txt_registfee.getText())+1;
                txt_registfee.setText(registfee+"");
            }else{
                Double registfee = Double.parseDouble(txt_registfee.getText())-1;
                txt_registfee.setText(registfee+"");
            }
        });
    }
}
