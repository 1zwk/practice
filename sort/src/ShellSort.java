import java.util.Arrays;

/**
 * 希尔排序。
 * 思路：利用插入排序数组越接近有序，效率越好，在插入排序之间进行预排序。
 * 如何分组：动态分组，开始分多组，越来越少。
 * 分组大小：1.gap = size/3 + 1    2.gap = size / 2;
 * 时间复杂度：最好（有序）：O（n）  平均：O（n^1.3-1.4)   最坏（逆序）：O（n^2)
 * 空间复杂度：O（1）
 * 稳定性：不稳定，相同的两个数可能分道不同的组里。
 */
public class ShellSort {
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (true) {
            gap = gap/ 3 + 1;//gap 每次要进行变化，不能直接定义为 array.length/3 + 1;
            insertSortWithGap(array, gap);
            if (gap == 1) {
                return;
            }
        }
    }

    private static void insertSortWithGap(int[] array, int gap) {
        for (int i = 0; i < array.length - gap; i++) {
            int j;
            int key = array[i + gap];
            for (j = i; j >= 0 && array[j] > key; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 23, 4, 5, 63, 3, 2, 5, 7, 1, 0};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }


}
