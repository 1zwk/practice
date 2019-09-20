/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
思路：1.先排序,
2.遍历数组，选出三个数，i,next和last，相加如果小于0，就把next向右移，大于0，就把last向左移。
3.去掉重复的，如果相同就把数再向下一位走一步。

 */
public class Sum3 {
    public static List<List<Integer>> sum3(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);

        int next = 0;
        int last = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            next = i + 1;
            while (next < last) {
                if (next < last && array[i] + array[next] + array[last] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(array[i]);
                    list.add(array[next]);
                    list.add(array[last]);
                    result.add(list);

                    while (next < last && array[next] == array[next++]) {
                        next++;
                    }
                    next++;
                    while (next < last && array[last] == array[last--]) {
                        last--;
                    }
                    last--;
                }
                if (next < last && array[i] + array[next] + array[last] < 0) {
                    next++;
                }
                if (next < last && array[i] + array[next] + array[last] > 0) {
                    last--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {-1,-1, 0, 1, 2, -1, -4};
        System.out.println(sum3(array));

    }

}
