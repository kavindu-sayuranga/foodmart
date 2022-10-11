
package lk.foodmart.superMarket.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.foodmart.superMarket.bo.BOFactory;
import lk.foodmart.superMarket.bo.custom.MainReportBO;
import lk.foodmart.superMarket.bo.custom.impl.MainReportBOImpl;
import lk.foodmart.superMarket.dto.CustomDTO;
import lk.foodmart.superMarket.view.tdm.CustomTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainReportsFormController {

    public TableView<CustomTM>tblMostItem;
    public TableView<CustomTM>tblLeastItem;
    public JFXButton btnAnually;
    public AnchorPane apnMain;


    private final MainReportBO mainReportBO = (MainReportBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MAIN_REPORT);


    public void initialize() throws SQLException, ClassNotFoundException {
        tblMostItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblMostItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblMostItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("packSize"));
        tblMostItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblMostItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderQty"));


        tblLeastItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblLeastItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblLeastItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("packSize"));
        tblLeastItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblLeastItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderQty"));

        setMostItem();
        setLeastItem();
    }

    private void setMostItem() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> item = mainReportBO.MostMovableItem();
        for (CustomDTO customDTO : item) {
            tblMostItem.getItems().add(new CustomTM(customDTO.getItemCode(), customDTO.getDescription(), customDTO.getPackSize(), customDTO.getUnitPrice(), customDTO.getOrderQty()));
        }

    }

    private void setLeastItem() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> item = mainReportBO.LeastMovableItem();
        for (CustomDTO customDTO : item) {
            tblLeastItem.getItems().add(new CustomTM(customDTO.getItemCode(), customDTO.getDescription(), customDTO.getPackSize(), customDTO.getUnitPrice(), customDTO.getOrderQty()));
        }
    }


    public void btnDailyReportOnAction(ActionEvent actionEvent) throws IOException {
        apnMain.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/DailyReportForm.fxml"));
        apnMain.getChildren().add(parent);
    }

    public void btnMonthlyReportOnAction(ActionEvent actionEvent) throws IOException {
        apnMain.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/MonthlyReportForm.fxml"));
        apnMain.getChildren().add(parent);
    }

    public void btnAnuallyReportOnAction(ActionEvent actionEvent) throws IOException {
        apnMain.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AnnuallyReportForm.fxml"));
        apnMain.getChildren().add(parent);
    }
}
