package com.his.controller;

import com.his.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * 主功能界面的控制器
 */
public class MainViewController implements Initializable {
    public static int level;        //表示当前登录医生的身份：1.挂号医生，2.看诊医生，3.药房医生
    @FXML
    private Menu ghmenu;
    @FXML
    private Menu kzmenu;
    @FXML
    private Menu yfmenu;

    public static Stage primaryStage;      //主舞台对象
    public Menu getGhmenu() {
        return ghmenu;
    }

    public void setGhmenu(Menu ghmenu) {
        this.ghmenu = ghmenu;
    }

    public Menu getKzmenu() {
        return kzmenu;
    }

    public void setKzmenu(Menu kzmenu) {
        this.kzmenu = kzmenu;
    }

    public Menu getYfmenu() {
        return yfmenu;
    }

    public void setYfmenu(Menu yfmenu) {
        this.yfmenu = yfmenu;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("主功能界面的初始化方法");
        if(level == 1){
            kzmenu.setDisable(true);
            yfmenu.setDisable(true);
        }else if(level == 2){
            ghmenu.setDisable(true);
            yfmenu.setDisable(true);
        }else{
            ghmenu.setDisable(true);
            kzmenu.setDisable(true);
        }
    }

    /**
     * 现场挂号对应的方法
     */
    public void addRegisterView(){
        FXMLLoader loader = new FXMLLoader();
        URL url = MainApplication.class.getResource("view/AddRegistView.fxml");
        loader.setLocation(url);
        try{
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage registStage = new Stage();
            registStage.setScene(scene);
            registStage.setTitle("挂号收费");
            registStage.initOwner(primaryStage);
            registStage.initModality(Modality.WINDOW_MODAL);
            AddRegistViewController.registStage = registStage;
            registStage.showAndWait();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addConsultation(){
        FXMLLoader loader = new FXMLLoader();
        URL url = MainApplication.class.getResource("view/ConsultationView.fxml");
        loader.setLocation(url);
        try{
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage consultStage = new Stage();
            consultStage.setScene(scene);
            consultStage.setTitle("医生看诊");
            consultStage.initOwner(primaryStage);
            consultStage.initModality(Modality.WINDOW_MODAL);
            ConsultationViewController.primaryStage = primaryStage;
            ConsultationViewController.consultStage = consultStage;     //目的为了看诊结束后直接关闭当前看诊界面
            consultStage.showAndWait();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addPharmacyView(){
        FXMLLoader loader = new FXMLLoader();
        URL url = MainApplication.class.getResource("view/PharmacyView.fxml");
        loader.setLocation(url);
        try{
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage pharmcyStage = new Stage();
            pharmcyStage.setScene(scene);
            pharmcyStage.setTitle("药房取药");
            pharmcyStage.initOwner(primaryStage);
            pharmcyStage.initModality(Modality.WINDOW_MODAL);
            PharmacyViewController.primaryStage = primaryStage;     //目的为了药房界面的提示框需要用的
            PharmacyViewController.pharmcyStage = pharmcyStage;     //目的为了看诊结束后直接关闭当前看诊界面
            pharmcyStage.showAndWait();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

