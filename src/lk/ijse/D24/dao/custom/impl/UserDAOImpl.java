package lk.ijse.D24.dao.custom.impl;

import lk.ijse.D24.dao.custom.UserDAO;
import lk.ijse.D24.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
    @Override
    public List<User> loadAll() {
        String hql="FROM User";
        Query query = session.createQuery(hql);
        List<User> list =query.list ();
        session.close();
        return list;
    }

    @Override
    public int save(User user) {
        return (int) session.save (user);
    }

    @Override
    public void update(User user) {
        session.update (user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User getObject(int id) throws Exception {
        return session.get (User.class,id);
    }


    @Override
    public List<Integer> userIds() {
        String hql = "SELECT id from User ";
        Query<Integer> query=session.createQuery (hql);
        List<Integer> results = query.list();
        session.close();
        return results;
    }
}
