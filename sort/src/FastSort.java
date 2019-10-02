import java.util.Arrays;
import java.util.Scanner;

public class FastSort {
    public static void fastSort(int[] array) {
        fastSortInternal(array, 0, array.length - 1);
    }

    private static void fastSortInternal(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition3(array, left, right);
        //int[] indecis = partition4(array, left, right);
        fastSortInternal(array, left, pivotIndex - 1);
        fastSortInternal(array, pivotIndex + 1, right);
        //fastSortInternal(array, left, indecis[0] - 1);
        //fastSortInternal(array, indecis[1] + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            while (less < great && array[great] >= pivot) {
                great--;
            }
            swap(array, less, great);
        }
        swap(array, right, less);
        return less;
    }

    private static void swap(int[] array, int less, int great) {
        int tmp = array[less];
        array[less] = array[great];
        array[great] = tmp;
    }

    //挖坑法
    private static int partition2(int[] array, int left, int right) {
        int pivot = array[right];//挖坑法，第一步保存的必须是基准值，而不是它的下标，因为值会在埋坑使变化
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            array[great] = array[less];
            while (less < great && array[great] >= pivot) {
                great--;
            }
            array[less] = array[great];
        }
        array[less] = pivot;
        return less;
    }

    //
    public static int partition3(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        // [left, less) < pivot
        // [less, i)    >= pivot
        // [i, right)	?
        for (int i = left; i < right; i++) {  //为啥不用i = left + 1;因为如果用的话，最后一次交换的时候
                                              // less是right - 1，和right交换会破坏已经排好的数组，
            if (array[i] < pivot) {
                swap(array, less, i);
                less++;
            }
        }
        swap(array, less, right);
        return less;
    }


    public static int[] partition4(int[] array, int left, int right){
        int pivot = array[right];
        int less = left;
        int i = left;
        int great = right;
        while(i < great){
            if(array[i] == pivot){
                i++;
            }else if(array[i] < pivot){
                swap(array, i, less);
                i++;
                less++;
            }else{
                while(i < great && array[great] > pivot){
                    great--;
                }
                swap(array, great, i);
            }
        }
        return new int[] {less, great - 1};
    }
    public static void main(String[] args) {
        int[] array = {1, 23, 4, 5, 63, 3, 2, 5, 7, 1, 0};
        fastSort(array);
        System.out.println(Arrays.toString(array));

    }

}
