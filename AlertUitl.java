package com.his.util;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * 提示框配置工具类
 */
public class AlertUitl {
    /**
     * 配置警告提示框
     */
    public static void showAlert(Stage primaryStage,String title,String headText,String contentText){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(primaryStage);
        alert.setTitle(title);
        alert.setHeaderText(headText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
