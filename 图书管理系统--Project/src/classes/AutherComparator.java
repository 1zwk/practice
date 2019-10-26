package classes;

import java.util.Comparator;

public class AutherComparator implements Comparator<Books> {
    @Override
    public int compare(Books o1, Books o2) {
        return o1.getWriter().compareTo(o2.getWriter());
    }
}
