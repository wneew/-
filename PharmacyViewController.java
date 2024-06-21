package com.his.controller;

import com.his.entity.PharmacyDTO;
import com.his.entity.Registinfo;
import com.his.io.FileIO;
import com.his.util.AlertUitl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;

public class PharmacyViewController {
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
    private TextArea txt_prescription;    //处方开药（逗号分割）
    @FXML
    private Label txt_drugprice;       //药品总价

    @FXML
    private TableView<PharmacyDTO> txt_tview;
    @FXML
    private TableColumn<PharmacyDTO,String> txt_prescriptionColumn;

    public static Stage primaryStage;
    public static Stage pharmcyStage;
    public void queryPharmacy(){
        List<Registinfo> rlist = (List<Registinfo>) FileIO.readObject("registinfo.txt");
        Integer id = Integer.parseInt(txt_id.getText());

        boolean flag = true;
        String[] prescrption = null;
        for(Registinfo reg:rlist){

            if(id.intValue() == reg.getId().intValue() && reg.getVisitstate() == 2){
                flag = false;
                txt_realname.setText(reg.getRealname());
                txt_gender.setText(reg.getGender());
                txt_age.setText(reg.getAge()+"");
                txt_cardnumber.setText(reg.getCardnumber());
                txt_drugprice.setText(reg.getDrugprice()+"");
                prescrption = reg.getPrescrption().split(";");
                //以下就是药品处方列表显示的代码
                ObservableList<PharmacyDTO> list = FXCollections.observableArrayList();
                for(String str:prescrption){
                    list.add(new PharmacyDTO(str));
                }
                txt_tview.setItems(list);
                txt_prescriptionColumn.setCellValueFactory(cellData->cellData.getValue().valueProperty());
                break;
            }

        }
        if(flag){
            AlertUitl.showAlert(primaryStage,"查询失败","没有当前要查询的病例","请填写正确的病历号");
            txt_realname.setText("");
            txt_gender.setText("");
            txt_cardnumber.setText("");
            txt_age.setText("");
        }
    }

    public void dispensing(){
        List<Registinfo> rlist = (List<Registinfo>) FileIO.readObject("registinfo.txt");
        Integer id = Integer.parseInt(txt_id.getText());
        for(Registinfo reg:rlist) {
            if (id.intValue() == reg.getId().intValue() ) {
                reg.setVisitstate(3);
                AlertUitl.showAlert(primaryStage,"发药成功","当前药品已经发放","请患者及时取走药品");
                break;
            }
        }
        pharmcyStage.close();
        FileIO.writeObject("registinfo.txt",rlist);
    }

}
