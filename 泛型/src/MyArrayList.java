public class MyArrayList<E> {
    private E[] array;
    private int size;


    //泛型定义的交换函数，把<E>放在返回值之前，可以交换任意类型。
    private  static <E>void  swap( E[] array, int i, int j ){
        E t = array[i];
        array[i] = array[j];
        array[j] = t;

    }

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        // 了解：1. 泛型无法定义泛型数组
        // 压制警告的注解
        array = (E[])new Object[100];
        size = 0;
    }



}
