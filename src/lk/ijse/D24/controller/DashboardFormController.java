package lk.ijse.D24.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    public Label lblStudents;
    public Label lblRooms;
    public Label lblReservations;
    public AnchorPane anchorPane;

    public void lblStudentOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/StudentForm.fxml"))));
        stage.setTitle("STUDENT");
        stage.centerOnScreen();
        stage.show();
    }

    public void lblRoomOnAction(MouseEvent mouseEvent) throws IOException {

    }

    public void lblReservationOnAction(MouseEvent mouseEvent) throws IOException {

    }

    public void lblPlanOnAction(MouseEvent mouseEvent) throws IOException {

    }

    public void lblSettingOnAction(MouseEvent mouseEvent) throws IOException {

    }

    public void lblLogoutOnAction(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
