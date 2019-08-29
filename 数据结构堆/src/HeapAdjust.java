import java.util.Arrays;

public class HeapAdjust {
    /**
     * 堆是满足以完全二叉树层序遍历存在数组之中的一组数，空间上想象为一个堆。
     * 前提：除了要调整的位置，其他位置已经满足堆的性质。
     *
     * @param array 被看成堆的数组
     * @param size  要调整的个数
     * @param index 调整位置的下标
     */
    //大堆向下调整。
    public static void heapify(int[] array, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }
            int max = left;
            if (left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }
            if (array[max] <= array[index]) {
                return;
            }
            swap(array, max, index);
            index = max;
        }
    }

    //小堆向下调整
    public static void heapifySmall(int[] array, int size, int index) {
        while (true) {
            if (index * 2 + 1 >= size) {
                return;
            }

            int min = index * 2 + 1;
            if (min + 1 < size && array[min + 1] < array[min]) {
                min = min + 1;
            }
            if (array[min] >= array[index]) {
                return;
            }
            swap(array, array[min], array[index]);
            index = min;
        }
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


    //大堆向上调整
    public static void adjustUp(int[] array, int index) {
        while (true) {
            if (index == 0) {
                return;
            }
            int parent = (index - 1) / 2;
            if (array[parent] >= array[index]) {
                return;
            }
            swap(array, parent, index);
            index = parent;
        }
    }

    //创建堆
    public static void createHeap(int[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(array, size, i);
        }
    }


    public static void createHeapMin(int[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            adjustUp(array, i);
        }
    }
    public static void main(String[] args) {
        int[] array = {3, 5, 2, 4, 9, 0, 1, 9, 8, 4, 7, 2, 3, 8, 6, 3};
        //createHeap(array, array.length);
        //System.out.println(Arrays.toString(array));
        createHeapMin(array,array.length);
        System.out.print(Arrays.toString(array));
    }
}
