package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.UserBO;
import lk.ijse.D24.config.SendMail;
import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dto.UserDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.mail.MessagingException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class UserCreateFormController implements Initializable {
    public TextField txtEmail;
    public TextField txtPassword;
    public TextField txtName;
    public TextField txtRePassword;
    public Label lblID;
    public AnchorPane anchorPane;

    private UserBO userBO = (UserBO) BOFactory.getBO (BOFactory.BOTypes.USER);

    public void btnCreateOnAction(ActionEvent event) throws MessagingException {
        int userID= 0;
        String UserName=txtName.getText();
        String password=txtPassword.getText();
        String rePassword=txtRePassword.getText();
        String email=txtEmail.getText();

        if(emailValidate()){
            if(password.equals(rePassword)){
                userBO.saveUser(new UserDTO(
                        userID,
                        UserName,
                        password,
                        email
                ));
                new Alert (Alert.AlertType.CONFIRMATION, "User created successfully").show ();
                SendMail.outMail ("YOU ARE USER IN D24HOSTEL SYSTEM",email,"D24HOSTEL");
                Stage stage4 = (Stage) anchorPane.getScene().getWindow();
                stage4.close();
            }
        }

    }

    private void clearFeilds() {
        txtRePassword.clear ();
        txtEmail.clear ();
        txtPassword.clear ();
        lblID.setText("");
        txtName.clear ();
    }

    private boolean emailValidate() {
        String email=txtEmail.getText();
        if(!email.matches("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$")){
            new Alert(Alert.AlertType.ERROR, "Invalid Email").show ();
            txtEmail.requestFocus ();
            return false;
        }
            return true;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setUserID();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setUserID() throws SQLException {
//        int userID=nextID();
//        lblID.setText(String.valueOf(userID));
    }

//    private int nextID() throws SQLException {
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        Query query = session.createQuery("select id from User order by id desc");
//
//        int nextID = 1;
//
//        if (query.list().size() == 0) {
//            return nextID;
//        } else {
//            int id = 0;
//            for (int i = 0; i < query.list().size(); i++) {
//                id = (int) query.list().get(id);
//            }
//            transaction.commit();
//            session.close();
//            return id;
//        }
//
//    }
}
