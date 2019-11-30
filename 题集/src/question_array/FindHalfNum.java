package question_array;
/**
 * 标题：n个数里出现次数大于等于n/2的数
 * 【n个数里出现次数大于等于n/2的数】输入n个整数，输出出现次数大于等于数组长度一半的数。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 思路一：
 * 使用“抵消”的思想。如果这个数大于或者等于这组数的一半，那么用这个数和不同于这个数的数相抵消，
 * 那么剩下的这个数数量一定大于等于0；但是最后要把这个数带进数组检查一下，因为如果前面都抵消了
 * 只剩下最后一个数或者最后两个不同得数，也可能为count也可能为0。
 * 思路二：
 * 将整个数组排序，既然出现次数大于等于一半，那么下标n/2的位置一定就是这个数
 * （因为题目说明一定有这个数，如果存在没有的可能那就不可以用这个思路）
 * 优化：可以借用快排做partition的思想来写
 */
public class FindHalfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] a = str.split(" ");
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }
        int result = find(b);
        System.out.println(result);

    }

    private static int find(int[] a) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                temp = a[i];
                count++;
            } else if(temp == a[i]){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < a.length; i++) {
            if (temp == a[i]) {
                count++;
            }
        }
        if(count >= a.length/2){
            return temp;
        }
        return Integer.MAX_VALUE;
    }
}

/*class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100];
        int i = 0;
        while(sc.hasNext()){
            a[i++] = sc.nextInt();
        }
        int result = find(a);
        System.out.println(result);

    }

    private static int find(int[] a) {
        if(a == null && a.length < 1){
            return  Integer.MAX_VALUE;
        }
        int count = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                temp = a[i];
                count++;
            } else {                                   //如何把list中得到的元素转为int
                temp = (temp == a[i] ? count++ : count--);
            }
        }
        count = 0;
        for (int i = 0; i < a.length; i++) {
            if (temp == a[i]) {
                count++;
            }
        }
        if (count >= a.length / 2) {
            return temp;
        }
        return Integer.MAX_VALUE;
    }
}*/
