package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteUser(long id) {
        User user = new User();
        user.setId(id);
        sessionFactory.getCurrentSession().delete(user);
        //sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(User.class, id));
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

}
