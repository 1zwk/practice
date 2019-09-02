import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array){
        mergeSortInternal(array, 0, array.length);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        int length = high - low;
        if(length <= 1){
            return;
        }

        int mid = (low + high)/2;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int length = high - low;
        int[] extra = new int[length];

        int iLeft = low;
        int iRight = mid;
        int iExtra = 0;
        while(iLeft < mid && iRight < high){
            if(array[iLeft] <= array[iRight]){
                extra[iExtra++] = array[iLeft++];
            }else{
                extra[iExtra++] = array[iRight++];
            }
        }
        while(iLeft < mid){
            extra[iExtra++] = array[iLeft++];
        }
        while(iRight < high){
            extra[iExtra++] = array[iRight];
        }

        for(int i = 0; i < length; i++){
            array[low + 1] = extra[i];
        }
    }

    //非递归写法
    private static void mergeNoR(int[] array) {
        for (int i = 1; i < array.length; i = i * 2){ //循环次数是以2 为底的log^array.length
            for(int j = 0; j < array.length; j = j + i * 2){ //
                int low = j;
                int mid = j + i;
                int high = mid + i;
                if(mid > array.length){
                    continue;
                }
                if(high > array.length){
                    high = array.length;
                }

                merge(array, low, mid ,high);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 23, 4, 5, 63, 3, 2, 5, 7, 1, 0};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
