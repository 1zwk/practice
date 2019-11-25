package question_array;
import java.util.*;

/**
 * 题目：给定n+1个以空格隔开的数，最后一个数为k，请找出n个数中最小的k个，以空格隔开输出，输出从小到大
 */
public class FindLastK {
    /**
     思路一：把输出处理后变为int数组，然后排序，输出前k个就好。
     注意：输出为空格间隔的时候，最后一个数后不应该还有空格。
     还有要判断数组是否够看个，这道题是默认够了。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){//循环处理多个输入的case
            String[] str = sc.nextLine().split(" ");
            int k = Integer.parseInt(str[str.length-1]);//保存k的值
            int[] array = new int[str.length - 1];
            for(int i=0; i<str.length-1; i++){//把string[] 变为int[]，只遍历前n个数加入数组，n+1为k
                array[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(array); //排序
            for(int i = 0; i<k; i++){
                System.out.print(array[i]);//先输出数字，后面跟着空格
                if(i != k-1){
                    System.out.print(" ");//需要每个输出之间带空格，但是最后一个输出后不应该有空格
                }
            }
        }
    }
}
