package fun.li6q.javaeetk4.dao;

import fun.li6q.javaeetk4.entity.User;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Vector;

@Named
@Stateful
@ApplicationScoped
public class DaoImpl implements Dao {
    @Inject
    private EntityManager db;

    @Override
    public User fetchUserByDisplayNameAndPasswordOrNull(String displayName, String password) {
        try {
            Query query = db.createQuery(
                    "select u from User u where u.displayName = :displayName and u.password = :password"
            );
            query.setParameter("displayName", displayName);
            query.setParameter("password", password);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User createUser(String displayName, String password) {
        User u = new User(displayName, password);
        db.persist(u);
        return u;
    }

    @Override
    public Vector<User> listAllUser() {
        try {
            Query query = db.createQuery(
                    "select id, displayName from User"
            );
            List<Object[]> rows = (List<Object[]>) query.getResultList();
            Vector<User> vector = new Vector<>();
            for (Object[] row : rows) {
                vector.add(new User((Long) row[0], (String) row[1], ""));
            }
            return vector;
        } catch (NoResultException e) {
            return null;
        }
    }
}
