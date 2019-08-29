import java.util.Arrays;

/**
 * 插入排序
 * 思路：假设第一个数已经有序，从无序区间里面的第一个数插入到有序区间里
 * 有序区间[0, i]
 * 无序区间[i+1, array.length)
 * 每次要搬运的值array[i+1];
 * 时间复杂度：最好（有序）：O（n）  平均：O（n^2)   最坏（逆序）：O（n^2)
 * 空间复杂度：O（1）
 * 稳定性：稳定
 */
public class InsertSort {
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i + 1];//后面搬运会覆盖掉key，故保存它的值
            int j;//要使用他循环结束后的值，故定义在外面。
            for (j = i; j >= 0; j--) {//循环有序区间，找到key应该插入的位置（j+1）
                if (array[j] <= key) {
                    break;
                }
            }
            for (int k = i; k > j; k--) {//把[j,i]的值后移一位，即把比key大的有序区间往后移一位。
                array[k + 1] = array[k];
            }
            array[j + 1] = key;//把key插入。

        }
    }


    public static void insertSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i + 1];//后面搬运会覆盖掉key，故保存它的值
            int j;//要使用他循环结束后的值，故定义在外面。
            for (j = i; j >= 0 && array[j] > key ; j--) {//循环有序区间，找到key应该插入的位置（j+1）
               array[j+1] = array[j];
            }
            array[j + 1] = key;//把key插入。

        }
    }
    public static void main(String[] args) {
        int[] array = {1, 23, 4, 5, 63, 3, 2, 5, 7, 1, 0};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }


}
