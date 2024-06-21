package com.his.controller;

import com.his.MainApplication;
import com.his.entity.Doctor;
import com.his.io.FileIO;
import com.his.util.AlertUitl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 登录界面的控制器
 */
public class LoginViewController {

    @FXML
    private TextField txt_id;
    @FXML
    private PasswordField txt_password;

    public static Stage primaryStage;
    public TextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(TextField txt_id) {
        this.txt_id = txt_id;
    }

    public PasswordField getTxt_password() {
        return txt_password;
    }

    public void setTxt_password(PasswordField txt_password) {
        this.txt_password = txt_password;
    }

    public void login(){
        String id = txt_id.getText();
        String password = txt_password.getText();
        List<Doctor> list =(List<Doctor>) FileIO.readObject("doctor.txt");
        boolean isLogin = false;
        if(id.equals("guahao") && password.equals("guahao")){
           AlertUitl.showAlert(primaryStage,"登录成功","挂号医生登录成功","当前挂号医生: guhao");
           isLogin = true;
           MainViewController.level = 1;
        }else if(id.equals("yaofang") && password.equals("yaofang")){
            AlertUitl.showAlert(primaryStage,"登录成功","药房医生登录成功","当前药房医生: yaofang");
            isLogin = true;
            MainViewController.level = 3;
        }else{
            for(Doctor d:list){
                if(d.getId().equals(id) && d.getPassword().equals(password)){
                    AlertUitl.showAlert(primaryStage,"登录成功","看诊医生登录成功","当前看诊医生: "+d.getRealname());
                    isLogin = true;
                    MainViewController.level = 2;
                    ConsultationViewController.doctor = d;
                    break;
                }
            }
        }
        if(isLogin){
            //跳转到功能主界面
            FXMLLoader loader = new FXMLLoader();
            URL url = MainApplication.class.getResource("view/MainView.fxml");
            loader.setLocation(url);
            try {
                AnchorPane pane = loader.load();
                Scene scene = new Scene(pane);
                primaryStage.setScene(scene);
                MainViewController.primaryStage = primaryStage;
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            AlertUitl.showAlert(primaryStage,"登录失败","用户名密码输入错误","请重新输入用户名和密码");
        }
    }
}
