package lk.ijse.D24.dto;

import lk.ijse.D24.entity.Reservation;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class RoomDTO {

    private int id;
    private int type_id;
    private String type;
    private double key_money;
    private int quantity;


    public RoomDTO() {
    }

    public RoomDTO(int id,int type_id, String type, double key_money, int quantity) {
        this.id = id;
        this.type_id=type_id;
        this.type = type;
        this.key_money = key_money;
        this.quantity = quantity;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getKey_money() {
        return key_money;
    }

    public void setKey_money(double key_money) {
        this.key_money = key_money;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
