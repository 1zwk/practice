package classes;

import java.util.Comparator;

public class priceComparator implements Comparator<Books> {
    private boolean asc;

    public priceComparator(boolean asc){
        this.asc = asc;
    }
    @Override
    public int compare(Books o1, Books o2) {//Q：好像double没有compareTo方法
        if(asc){
            return (int)
        }
    }
}
