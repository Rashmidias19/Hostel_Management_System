package lk.ijse.D24.dao.custom;

import lk.ijse.D24.dao.CrudDAO;
import lk.ijse.D24.entity.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation> {
    List<Integer> resIds();
}
