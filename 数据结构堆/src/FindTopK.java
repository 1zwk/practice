/**
 * 如何在一组数据中找最大得K个数，堆排序写法。
 */

import java.util.Arrays;
import java.util.Random;

public class FindTopK {
    //找到一堆数中最大的K个。
    public static int[] findK(int[] array, int k){
        int[] top = new int[k];
        for(int i = 0; i< k; i++){
            top[i] = array[i];
        }
        creatHeapMin(top, top.length);
        for(int i = k; i< array.length; i++){
            if(array[i] > top[0]){
                top[0] = array[i];
                heapifySmall(top, top.length, 0);
            }
        }
        return top;
    }

    private static void creatHeapMin(int[] top, int length) {
        for(int i = (length-2) / 2; i > 0; i--){
           heapifySmall(top, length, i);
        }
    }

    private static void heapifySmall(int[] array, int size, int index){
        while(true){
            int left = 2 * index + 1;
            if(left >= size){
                return;
            }
            int min = left;
            if(left + 1 < size && array[left + 1] < array[left]){
                min = left + 1;
            }

            if(array[index] < array[min]){
                return;
            }
            swap(array, index, min);
            index = min;
        }
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        Random random = new Random(2019);
        int[] array = new int[100];
        for(int i = 0; i< array.length; i++){
            array[i] = random.nextInt(1000);
        }
        int[] top = findK(array, 5);
        System.out.println(Arrays.toString(top));
        Arrays.sort(array);
        System.out.println(Arrays.toString(
                Arrays.copyOfRange(array, array.length - 10, array.length)));

    }



}
