package lk.foodmart.superMarket.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.foodmart.superMarket.bo.BOFactory;
import lk.foodmart.superMarket.bo.custom.DashBoardBO;
import lk.foodmart.superMarket.bo.custom.impl.DashBoardBOImpl;
import lk.foodmart.superMarket.dto.CustomDTO;
import lk.foodmart.superMarket.dto.ItemDTO;
import lk.foodmart.superMarket.view.tdm.CustomTM;
import lk.foodmart.superMarket.view.tdm.CustomerTM;
import lk.foodmart.superMarket.view.tdm.ItemTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardFormController {
    public Label lblTotalOrder;
    public Label lblItemType;
    public Label lblTotalCustomer;
    public TextField txtSearchItem;
    public TableView<ItemTM> tblItem;
    public TableView<CustomTM> tblCustomer;
    public JFXComboBox<String> cmbSelectCustomer;


    private final DashBoardBO dashBoardBO = (DashBoardBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.DASHBOARD);

    public void initialize() throws SQLException, ClassNotFoundException {

        tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CusID"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));

        setLabelValue();
        setCmbData();

        cmbSelectCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (cmbSelectCustomer.getValue() != null) {
                try {
                    setCustomerTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        setItemTableData();
        setCustomerTable();

    }

    public void setItemTableData() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItemName = dashBoardBO.getAllItemName();

        for (ItemDTO itemDTO : allItemName) {
            tblItem.getItems().add(new ItemTM(
                    itemDTO.getItemCode(),
                    itemDTO.getDescription(),
                    itemDTO.getUnitPrice()
            ));
        }

    }

    public void searchItemOnAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        String search = "%" + txtSearchItem.getText() + "%";

        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            ArrayList<ItemDTO> itemDTOS = dashBoardBO.getSearchICodeDescription(search);
            ObservableList<ItemTM> itTm = FXCollections.observableArrayList();

            for (ItemDTO itDto : itemDTOS) {
                itTm.add(new ItemTM(
                        itDto.getItemCode(),
                        itDto.getDescription(),
                        itDto.getUnitPrice()
                ));
            }
            tblItem.getItems().clear();
            tblItem.getItems().addAll(itTm);
            tblItem.refresh();
        }
    }

    public void setCustomerTable() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> customerBuyingItems = dashBoardBO.getCustomerBuyingItems(cmbSelectCustomer.getValue());

        tblCustomer.getItems().clear();
        for (CustomDTO customerBuyingItem : customerBuyingItems) {
            tblCustomer.getItems().add(new CustomTM(
                    customerBuyingItem.getCusID(),
                    customerBuyingItem.getItemCode(),
                    customerBuyingItem.getDescription()
            ));
        }
    }

    private void setCmbData() throws SQLException, ClassNotFoundException {
        for (String cmbCustomerId : dashBoardBO.getCmbCustomerIds()) {
            cmbSelectCustomer.getItems().add(cmbCustomerId);
        }

    }

    public void setLabelValue() throws SQLException, ClassNotFoundException {
        lblItemType.setText(String.valueOf(dashBoardBO.getItemTypes()));
        lblTotalCustomer.setText(String.valueOf(dashBoardBO.getTotalCustomer()));
        lblTotalOrder.setText(String.valueOf(dashBoardBO.getOrderCount()));
    }
}
