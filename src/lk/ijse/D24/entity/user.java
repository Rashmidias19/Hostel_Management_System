package lk.ijse.D24.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @CreationTimestamp
    @Column(name = "logged_date")
    private Timestamp loggedDateTime;

    public user() {
    }

    public user(int id, String userName, String password, String email, Timestamp loggedDateTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.loggedDateTime = loggedDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getLoggedDateTime() {
        return loggedDateTime;
    }

    public void setLoggedDateTime(Timestamp loggedDateTime) {
        this.loggedDateTime = loggedDateTime;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", loggedDateTime=" + loggedDateTime +
                '}';
    }
}
