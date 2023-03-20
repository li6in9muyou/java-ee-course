package fun.li6q.javaeetk4.biz;

import jakarta.ejb.Local;

@Local
public interface ListDatabase {
    int add(int x, int y);

    String list();
}
