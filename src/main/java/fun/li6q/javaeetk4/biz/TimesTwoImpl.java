package fun.li6q.javaeetk4.biz;

import jakarta.ejb.Stateful;

@Stateful
public class TimesTwoImpl implements TimesTwo {
    int i = 1;

    @Override
    public int calculateTwo() {
        i *= 2;
        if (i < 0) {
            i = 1;
        }
        return i;
    }
}
