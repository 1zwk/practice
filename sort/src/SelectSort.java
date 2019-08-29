import java.util.Arrays;

 /*
   选择排序
  思路：每次指定两个值，一个最大值，一个最小值，把最小值放在左边，最大值放在右边，两边有序区间夹着
        无序区间。
        有个小坑，当第一个数就为最大值，遍历最小值和第一个数交换后，需要改变max的下标。
 */

public class SelectSort {

    public static void selectSort(int[] array) {
        //每次选最大的数
        for (int i = 0; i < array.length - 1; i++) {
            //无序区间【0，array.length - i)
            //有序区间【array.length - i, array.length)
            int max = 0;
            for (int j = 1; j < array.length - i ; j++) {//找无序区间最大值
                if(array[j] >= array[max]){//为什么把这一步判断放进for循环里结果错误？
                    max = j;                //因为要把数组全部跑一次找最大值，但是如果加了
                }                           //array[j] >= array[max],在判断里，大多数就进不去循环，直接跳出了。
            }
            swap(array, max, array.length - i - 1);//把最大值和无需区间最后一个数交换；
        }
    }


    public static void selectSort2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int max = left;
            int min = left;

            for (int i = left + 1; i <= right; i++) {
                if (array[min] > array[i]) {
                    min = i;
                }
                if (array[max] < array[i]) {
                    max = i;
                }
            }

            swap(array, min, left);
            if (left == max) {
                max = min;
            }
            swap(array, max, right);

            left++;
            right--;
        }

    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {1, 23, 4, 5, 63, 3, 2, 5, 7, 1, 0};
        selectSort(array);
        System.out.println(Arrays.toString(array));
        selectSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
