package com.his;

import com.his.controller.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL url = MainApplication.class.getResource("view/LoginView.fxml");
        loader.setLocation(url);
        LoginViewController.primaryStage = stage;   //将舞台对象传递给logincontroller
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setTitle("东软HIS云医院");
        stage.setScene(scene);
        stage.show();
    }
}
