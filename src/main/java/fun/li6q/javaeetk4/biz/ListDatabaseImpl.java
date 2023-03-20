package fun.li6q.javaeetk4.biz;

import fun.li6q.javaeetk4.dao.Dao;
import fun.li6q.javaeetk4.entity.User;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.Vector;
import java.util.logging.Logger;

@Stateless
public class ListDatabaseImpl implements ListDatabase {
    @Inject
    private Logger book;

    @Inject
    private Dao dao;

    @PostConstruct
    public void postConstruct() {
        book.info("adder post construct");
    }

    @Override
    public int add(int x, int y) {
        book.info(String.format("adder %d + %d = %d", x, y, x + y));
        return x + y;
    }

    @Override
    public String list() {
        Vector<User> list = dao.listAllUser();
        StringBuilder text = new StringBuilder();
        for (User u : list) {
            text.append(String.format("id: %d, displayName: %s\n", u.getId(), u.getDisplayName()));
        }
        return text.toString();
    }
}
