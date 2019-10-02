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
            extra[iExtra++] = array[iRight++];
        }

        for(int i = 0; i < length; i++){
            array[low + i] = extra[i];
        }
    }

    //非递归写法
    //把i理解为每次合并的最小单位，第一次就是1，第二次是2,4,8。。。就是 2*i;
    //把j理解为合并后的长度，第一次没合并，之后每次合并两个i，就是j += 2*i;
    private static void mergeNoR(int[] array) {
        for (int i = 1; i < array.length; i = i * 2){ //循环次数是以2 为底的log^array.length
            for(int j = 0; j < array.length; j = j + i * 2){ //
                int low = j;
                int mid = j + i;//合并是j + 2*i,一般就是j + i
                int high = mid + i;//把剩下的一半加上就是这一段的长度，即 mid + i;
                if(mid > array.length){//mid大于数组长度说明不足以进行一次合并，就跳出内部的合并循环
                    continue;
                }
                if(high > array.length){//要合并的长度大于数组长度就把high变成数组长度，
                                        // 就是还剩下多少就合并多少
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
