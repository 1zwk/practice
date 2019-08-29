/**
 * 实现一个优先级队列
 */
import java.util.*;


public class MyPriorityQueue {
   //先不考虑数组容量不够的问题
    private int[] array = new int[100];
    private int size = 0;




    //插入 时间复杂度O（logn)
    public void push(int element){
        array[size++] = element;
        HeapAdjust.adjustUp(array,size - 1);
    }

    //删除， 时间复杂度O(log(n))
    public int poll(){
        int e = array[0];
        array[0] = array[--size];
        HeapAdjust.heapify(array, size, 0);
        return e;
    }

    //O(1)
    public int peek(){
        return array[0];
    }

}
