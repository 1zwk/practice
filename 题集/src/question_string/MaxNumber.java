package question_string;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 *     示例 1:
 *
 *     输入: [10,2]
 *     输出: 210
 *     示例 2:
 *
 *     输入: [3,30,34,5,9]
 *     输出: 9534330
 *     说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/largest-number
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxNumber {
    private class largestComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);//a比b，是升序排序
            // b 比 a,这样的话排序就是降序排序，而本题后面要判断第一个数是否为0，所以只能采用降序
        }
    }

    public String largestNumber(int[] nums){
        //1.先把int类型转换为String
        String[] strs = new String[nums.length];
        for(int i = 0; i< nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        //2.对字符串数组strs进行比较器排序
        Arrays.sort(strs,new largestComparator());

        //3.特殊情况处理：如果字符串数组strs第一个字符串就是0，那意味着不用拼接了，都是0
        if(strs[0].equals("0")){
            return "0";
        }

        //4.拼接字符串
        String largest = new String();
        for(int i = 0; i< strs.length;i++){
            largest += strs[i];
        }

        return largest;
    }

    public static void main(String[] args) {
        MaxNumber m = new MaxNumber();
        m.largestNumber(new int[] {10,2});

    }
}
