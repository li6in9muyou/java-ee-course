package fun.li6q.javaeetk4;

public interface Dao {
    User fetchUserByDisplayNameAndPasswordOrNull(String displayName, String password);

    User createUser(String displayName, String password);
}
