package lk.ijse.D24.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.ReservationBO;
import lk.ijse.D24.bo.custom.RoomBO;
import lk.ijse.D24.bo.custom.StudentBO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    public Label lblStudents;
    public Label lblRooms;
    public Label lblReservations;
    public AnchorPane anchorPane;


    RoomBO roomBO = (RoomBO) BOFactory.getBO (BOFactory.BOTypes.ROOM);
    StudentBO studentBO = (StudentBO) BOFactory.getBO (BOFactory.BOTypes.STUDENT);
    ReservationBO reservationBO = (ReservationBO) BOFactory.getBO (BOFactory.BOTypes.RESERVATION);

    public void lblStudentOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/StudentForm.fxml"))));
        stage.setTitle("STUDENT");
        stage.centerOnScreen();
        stage.show();
    }

    public void lblRoomOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/RoomForm.fxml"))));
        stage.setTitle("ROOMS");
        stage.centerOnScreen();
        stage.show();
    }

    public void lblReservationOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml"))));
        stage.setTitle("RESERVATION");
        stage.centerOnScreen();
        stage.show();
    }

    public void lblPlanOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/PlanForm.fxml"))));
        stage.setTitle("PLAN");
        stage.centerOnScreen();
        stage.show();
    }

    public void lblSettingOnAction(MouseEvent mouseEvent) throws IOException {

    }

    public void lblLogoutOnAction(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblStudents.setText (String.valueOf (studentBO.loadAll ().size ()));
        lblRooms.setText(String.valueOf(roomBO.loadAll().size()));
        lblReservations.setText(String.valueOf(reservationBO.loadAll().size()));
    }
}
