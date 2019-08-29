import java.util.Arrays;

/**
 * 冒泡排序
 * 思路：遍历数组，每次把最大的数放到最后面。
 *
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {//减去1是因为两两交换，遍历到最后只剩一个不用换了
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    private static void swap(int[] array, int j, int i) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {1,23,4,5,63,3,2,5,7,1,0};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}

