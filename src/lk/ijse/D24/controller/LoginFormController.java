package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.UserBO;
import lk.ijse.D24.dto.UserDTO;

import javax.management.Notification;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    public ImageView imgEyeClose;
    public ImageView imgEyeOpen;
    public javafx.scene.control.TextField txtName;
    public javafx.scene.control.TextField txtShowPass;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private PasswordField txtPassword;
    
    private UserBO userBO = (UserBO) BOFactory.getBO (BOFactory.BOTypes.USER);

    public void btnSignOnAction(ActionEvent event) throws IOException {
        if(userCheck()){
            Stage stage=(Stage) anchorPane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"))));

            new Alert(Alert.AlertType.CONFIRMATION, "Login Successfully").show();
        }
    }

    private boolean userCheck() {
        String userName=txtName.getText();
        String password=txtPassword.getText();

        List<UserDTO> userDTOList= userBO.loadAll();

        for(UserDTO dto:userDTOList){
            if(dto.getUserName().equals(userName) && dto.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void txtCreateOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminForm.fxml"))));
        stage.setTitle("D24 HOSTEL");
        stage.centerOnScreen();
        stage.show();
    }

    public void txtForgotOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ForgotPasswordForm.fxml"))));
        stage.setTitle("D24 HOSTEL");
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imgEyeClose.setVisible(true);
        imgEyeOpen.setVisible(false);
        txtShowPass.setVisible(false);
        txtPassword.setVisible(true);
    }

    public void imgEyeCloseOnAction(MouseEvent mouseEvent) {
        imgEyeOpen.setVisible(true);
//        imgEyeClose.setVisible(false);
        txtPassword.setVisible(false);
        txtShowPass.setVisible(true);
        txtShowPass.setText(txtPassword.getText());
    }

    public void imgEyeOpenOnAction(MouseEvent mouseEvent) {
        imgEyeOpen.setVisible(false);
        imgEyeClose.setVisible(true);
        txtShowPass.setVisible(false);
        txtPassword.setVisible(true);
        txtPassword.setText(txtPassword.getText());
    }
}
