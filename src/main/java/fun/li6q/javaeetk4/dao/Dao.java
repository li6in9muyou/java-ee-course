package fun.li6q.javaeetk4.dao;

import fun.li6q.javaeetk4.entity.User;

import java.util.Vector;

public interface Dao {
    User fetchUserByDisplayNameAndPasswordOrNull(String displayName, String password);

    User createUser(String displayName, String password);

    Vector<User> listAllUser();
}
