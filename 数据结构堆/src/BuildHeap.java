import java.util.Arrays;

/**
 * 创建堆，从最后的一个叶子节点的父节点开始，遍历每一个节点进行向下调整。
 */
public class BuildHeap {
    public static void creatHeap(int[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            HeapAdjust.heapify(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 6, 8, 9, 3, 45};
        creatHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }

}