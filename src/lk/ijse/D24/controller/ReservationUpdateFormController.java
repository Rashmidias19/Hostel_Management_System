package lk.ijse.D24.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.ReservationBO;
import lk.ijse.D24.dto.ReservationDTO;
import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.dto.StudentDTO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationUpdateFormController implements Initializable {
    public AnchorPane anchorPane;
    public TextField txtAdvance;
    public Button btnSave;
    public ComboBox cmbStudentID;
    public Label lblName;
    public ComboBox cmbRoom;
    public Label lblType;
    public ComboBox cmbStatus;
    public DatePicker date;
    public ComboBox cmbReservation;

    private ReservationBO reservationBO = (ReservationBO) BOFactory.getBO (BOFactory.BOTypes.RESERVATION);


    public void btnSaveOnAction(ActionEvent event) {
    }

    public void btnBackOnAction(ActionEvent event) {
    }

    public void cmbStudentOnAction(ActionEvent event) {
        int stId = (int) cmbStudentID.getValue ();
        StudentDTO dto = reservationBO.getStudent (stId);
        lblName.setText (dto.getName());
    }

    public void cmbRoomOnAction(ActionEvent event) {
        int roomId = (int) cmbRoom.getValue ();
        RoomDTO dto = reservationBO.getRoom (roomId);
        lblType.setText (dto.getType ());
    }

    public void cmbReservationOnAction(ActionEvent event) {
        setData();
    }

    private void setData() {
        int resID= (int) cmbReservation.getValue();
        StudentDTO dto=reservationBO.getStudent(resID);
        RoomDTO rDto=reservationBO.getRoom(resID);
        cmbStudentID.setValue(dto.getId());
        cmbRoom.setValue(rDto.getId());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setResIDS();
    }

    private void setResIDS() {
        List<Integer> ResIds = reservationBO.getResIds();
        ObservableList reservations = FXCollections.observableArrayList (ResIds);
        cmbReservation.setItems (reservations);
    }
}
