/**
 * 给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。
 *
 * 如果无法这么操作，就请返回原数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,1]
 * 输出：[3,1,2]
 * 解释：
 * 交换 2 和 1
 *  
 *
 * 示例 2：
 *
 * 输入：[1,1,5]
 * 输出：[1,1,5]
 * 解释：
 * 这已经是最小排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/previous-permutation-with-one-swap
 */
public class ChangeOneFindMax {
        public int[] prevPermOpt1(int[] A) {
            for(int i = A.length - 2; i >= 0; i--){
                if(A[i] > A[i+1]){
                    int max = i+1;;
                    for(int j = i+2; j < A.length; j++){
                        if(A[j] < A[i] && A[j] > A[max]){
                            max = j;
                        }
                    }
                    int tem = A[i];
                    A[i] = A[max];
                    A[max] = tem;
                    return A;
                }
            }
            return A;
        }
}
