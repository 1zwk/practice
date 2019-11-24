package question_array;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/a2063993dd424f9cba8246a3cf8ef445
 * 来源：牛客网
 *
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，
 * 请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
 *
 * 输入描述:
 * 每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 *
 *
 * 输出描述:
 * 对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。
 * 示例1
 * 输入
 * 100311
 * 输出
 * 0:2
 * 1:3
 * 3:1
 */
public class CountDigit {
    /**
     * 思路：读取输入的字符串后，原本我是想把转为字符数组，但是其实不需要另外开辟空间保存他的字符数组
     *       只需一个数组，在遍历时把字符串的每一位通过charAt（）取出来统计数量，然后把数组非0的元素输出就好
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String n = sc.nextLine();
            int[] nums = new int[10];
            for(int i=0; i<n.length(); i++){//用下标代表数字，元素代表数量，存入数组
                nums[n.charAt(i) - '0']++;//因为是char形式，所以把每个数 减去字符‘0’就可以得到他们的int
            }
            for(int i=0; i<nums.length; i++){//遍历打印非0元素
                if(nums[i] != 0){
                    System.out.println(i+ ":" +nums[i]);//直接把非0元素格式输出。
                }
            }
        }
        sc.close();
    }
}
