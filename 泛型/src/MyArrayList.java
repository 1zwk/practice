public class MyArrayList<E> {
    private E[] array;
    private int size;


    private  static <E>void  swap( E[] array, int i, int j ){
        E t = array[i];
        array[i] = array[j];
        array[j] = t;

    }
}
