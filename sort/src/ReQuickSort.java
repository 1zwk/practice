import java.util.Arrays;


public class ReQuickSort {
    public int[] QuickSort(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);

        return sort(arr, 0, array.length - 1);
    }

    private int[] sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition4(arr, left, right);

            sort(arr, left, pivotIndex - 1);
            sort(arr, pivotIndex + 1, right);
        }
        return arr;
    }

    //[pivot,index),小于中间数
    //[index,i] 大于中间数
    //(i,right] 无序
    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;

        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private int partition2(int[] arr, int left, int right) {
        int pivot = arr[right];
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && arr[less] <= pivot) {
                less++;
            }
            while (less < great && arr[great] >= pivot) {
                great--;
            }
            swap(arr, less, great);
        }
        swap(arr, right, less);
        return less;
    }

    private int partition3(int[] arr, int left, int right) {
        int pivot = arr[left];
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && arr[great] >= pivot) {
                great--;
            }
            arr[less] = arr[great];
            while (less < great && arr[less] <= pivot) {
                less++;
            }
            arr[great] = arr[less];
        }
        arr[great] = pivot;
        return less;
    }


    private int partition4(int[] array, int left, int right){
        int pivot = right;
        int index = left;
        for(int i = index; i <= right; i++){
            if(array[i] < array[pivot]){
                swap(array, i, index);
                index++;
            }
        }
        swap(array, index, pivot);
        return index;
    }

    private void swap(int[] arr, int i, int index) {
        int tmp = arr[i];
        arr[i] = arr[index];
        arr[index] = tmp;
    }


    public static void main(String[] args) {
        int array[] = {3, 4, 7, 1, 3, 9, 5, 0, 34, 20};
        ReQuickSort r = new ReQuickSort();
        System.out.println(Arrays.toString(r.QuickSort(array)));
    }
}
