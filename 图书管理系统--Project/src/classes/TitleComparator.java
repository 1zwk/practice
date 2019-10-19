package classes;

import java.util.Comparator;

public class TitleComparator implements Comparator<Books> {

    @Override
    public int compare(Books o1, Books o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
