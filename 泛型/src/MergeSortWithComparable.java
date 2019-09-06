

import java.util.Arrays;
import java.util.Random;

public class MergeSortWithComparable {
    //使用Comparable来比较的归并排序。
    public static void mergeSort(Student[] array) {
        InterMerge(array, 0, array.length);
    }

    private static void InterMerge(Student[] array, int low, int high) {
        int length = high - low;
        if (length <= 1) {
            return;
        }
        int mid = (low + high) / 2;

        InterMerge(array, low, mid);
        InterMerge(array, mid, high);
        merge(array, low, mid, high);
    }

    private static void merge(Student[] array, int low, int mid, int high) {
        int length = high - low;
        int less = low;
        int great = mid;
        Student[] extra = new Student[length];
        int iExtra = 0;


        while (less < mid && great < high) {
            int r = array[less].compareTo(array[great]);
            if (r <= 0) {
                extra[iExtra++] = array[less++];
            } else {
                extra[iExtra++] = array[great++];
            }
        }

        while (less < mid) {
            extra[iExtra++] = array[less++];
        }
        while (great < high) {
            extra[iExtra++] = array[great++];
        }

        for (int i = 0; i < length; i++) {
            array[i + low] = extra[i];
        }
    }


    public static void main(String[] args) {
        Student[] s = new Student[5];
        Random random = new Random(28);
        for (int i = 0; i < s.length; i++) {
            s[i] = new Student();
            s[i].age = random.nextInt(100);
        }
        System.out.println(Arrays.toString(s));
        mergeSort(s);
        System.out.println(Arrays.toString(s));


    }
}
