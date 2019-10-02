import java.util.Arrays;

public class ReMargeSort {
    public static void mergeSort(int[] array) {

        interMerger(array, 0, array.length);
    }

    private static void interMerger(int[] array, int low, int high) {
        int length = high - low;
        while(length <= 1){
            return ;
        }

        int mid = (low + high) / 2;
        interMerger(array, low, mid);
        interMerger(array, mid, high);
        merge(array, low, mid, high);

    }

    private static void merge(int[] array, int low, int mid, int high) {
        int length = high - low;
        int[] extra = new int[length];

        int left = low;
        int right = mid;
        int extraIndex = 0;
        while (left < mid && right < high) {//因为左闭右开
            if (array[left] <= array[right]) {
                extra[extraIndex++] = array[left++];
            } else {
                extra[extraIndex++] = array[right++];
            }
        }
        while (left < mid) {
            extra[extraIndex++] = array[left++];
        }
        while (right < high) {
            extra[extraIndex++] = array[right++];
        }
        for (int i = 0; i < length; i++) {
            array[low + i] = extra[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 23, 4, 5, 63, 3, 2, 5, 7, 1, 0};
        mergeSort(array);
        System.out.println(Arrays.toString(array));

    }
}
