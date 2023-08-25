package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminFormController {
    public TextField txtName;
    public TextField txtPassword;
    public AnchorPane anchorPane;

    private String name="RashD";
    private String password="Maximboy31";

    public void btnSignOnAction(ActionEvent event) throws IOException {
        String userName=txtName.getText();
        String Password=txtPassword.getText();

        if(userName.equals(name)&& Password.equals(password)){
            Stage stage3 = new Stage();
            stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserCreateForm.fxml"))));
            stage3.show();

            Stage stage4 = (Stage) anchorPane.getScene().getWindow();
            stage4.close();
        }
    }
}
