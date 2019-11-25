package question_array;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/18ecd0ecf5ef4fe9ba3f17f8d00d2d66
 * 来源：牛客网
 *
 * Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。

 * 输入描述:
 * 输入为一个正整数N(1 ≤ N ≤ 1,000,000)

 * 输出描述:
 * 输出一个最小的步数变为Fibonacci数"
 * 示例1
 * 输入
 * 15
 * 输出
 * 2
 */
public class FibonacciArray {
    /**
     * 思路：很巧妙的思路,常规的思路是把fib求出来，然后遍历找和n差值最小的，
     *         但是这个思路利用了循环赋值来求出fib，然后求差值。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int a = 0;
            int b = 1;
            while(b < n){//循环赋值，结果相当于fib的迭代，当b一旦大于了n，那么比较a，b与n的差值，哪个小就输出。
                int temp = a+b;
                a = b;
                b = temp;
            }
            if(b-n < n-a){
                System.out.println(b-n);
            }else {
                System.out.println(n-a);
            }
        }
    }
}
