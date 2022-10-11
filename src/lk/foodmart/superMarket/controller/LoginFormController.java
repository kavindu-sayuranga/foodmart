package lk.foodmart.superMarket.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.foodmart.superMarket.util.ValidationUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class LoginFormController {
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public AnchorPane MainAnchorePane;
    public JFXComboBox<String>cmbSelectType;
    public JFXButton btnLogin;

    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();
    Pattern usernamePattern = Pattern.compile("^[A-z0-9]{3,10}$");
    LinkedHashMap<JFXPasswordField, Pattern> map1 = new LinkedHashMap<>();
    Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$");

    public void initialize(){
        storeValidation();
        cmbSelectType.getItems().addAll("Admin", "Cashier");
    }
    private void storeValidation() {
        map.put(txtUsername, usernamePattern);
        map1.put(pwdPassword, passwordPattern);

    }
    public void lordWindow() throws IOException {

        Stage stage = (Stage) MainAnchorePane.getScene().getWindow();
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/lk/foodmart/superMarket/view/HomeForm.fxml"));

        Parent root1 = loader1.load();
        Scene scene1 = new Scene(root1);

        stage.setScene(scene1);

        HomeFormController controller = loader1.getController();
        controller.getAllData(cmbSelectType.getValue());

        stage.centerOnScreen();


    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUsername.getText().trim();
        String password = pwdPassword.getText().trim();
        String type = cmbSelectType.getValue();

        if((userName.equalsIgnoreCase("kavi12") && password.equalsIgnoreCase("Kavi123") && type.equalsIgnoreCase("Admin")) || (userName.equalsIgnoreCase("sayu12") && password.equalsIgnoreCase("Sayu123") && type.equalsIgnoreCase("Cashier")) )  {

            lordWindow();

        }else{
            new Alert(Alert.AlertType.ERROR, "Please enter details correctly!").show();

        }
    }

    public void textFieldValidationOnAction(KeyEvent keyEvent) {
        Object response = ValidationUtil.validateJFXTextFields(map, btnLogin);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (response instanceof JFXTextField) {
                JFXTextField errorText = (JFXTextField) response;
                errorText.requestFocus();
            } else if (response instanceof Boolean) {

            }
        }
    }

    public void passwordFieldValidationOnAction(KeyEvent keyEvent) {
        Object response = ValidationUtil.validateJFXPasswordField(map1, btnLogin);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (response instanceof JFXPasswordField) {
                JFXPasswordField errorText = (JFXPasswordField) response;
                errorText.requestFocus();
            } else if (response instanceof Boolean) {

            }
        }
    }
}
