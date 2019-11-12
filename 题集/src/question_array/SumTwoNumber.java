package question_array;
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
好坑，以为相同的数是相等的数，
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumTwoNumber {
    //我的答案 O(N^2)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i< nums.length; i++){
            for(int j = nums.length - 1; j>i; j--){
                if((nums[i] + nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    //官方给的暴力法
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {//这样写不用写括号吧哈哈
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");//处理没有找到的情况
    }

    /*官方使用hash表来解决,
    一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
    然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。
    注意，该目标元素不能是 nums[i]nums[i] 本身！
    时间：O(N)  空间O(N)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //第三种 同样使用hash表，只遍历一次
    /*
    问题：像{2,2,3,4,5}这样的数组，当放到哈希表里的时候，就会丢掉键为2，值为0的键值对。
    答：但是无妨，因为存进去的必然是后续的2（后覆盖前），遍历是从数组开始遍历的，数组是由0开始的，
        0就是{ map.get(complement), i }的i,而map.get(complement)出来的值是后续的2的值。
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] array = { 2, 2, 3 ,5};
        System.out.println(Arrays.toString(twoSum3(array,4)));
    }
}
