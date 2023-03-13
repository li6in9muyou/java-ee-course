package fun.li6q.javaeetk4.dao;

import fun.li6q.javaeetk4.entity.User;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

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
}
