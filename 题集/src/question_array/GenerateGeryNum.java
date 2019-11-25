package question_array;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/50959b5325c94079a391538c04267e15
 * 来源：牛客网
 *
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
 * 请编写一个函数，使用递归的方法生成N位的格雷码。
 *
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 *
 * 测试样例：
 * 1
 * 返回：["0","1"]
 */
public class GenerateGeryNum {
    /**
     * 思路：
     * //方法一：递归
     * //递归的思路就是n位gray码是由n-1位gray码生成，举个例子简单一些：
     * //比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
     * //那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
     * //添加1后需要顺序反向就变成(110,111,101,100)
     * //组合在一起就是(000,001,011,010,110,111,101,100)
     */
    public static String[] getGray(int n) {
        // write code here
        String[] str = null;
        if (n == 1) {
            str = new String[]{"0", "1"};//如果n=1,直接返回结果，这个结果递归的结束条件
        } else {
            String[] temp = getGray(n - 1);//创建新的数组保存n-1的值。
            str = new String[2 * temp.length];//每次新的数组长度值是以前的两倍，
            for (int i = 0; i < temp.length; i++) {//这里要用的临时数组temp的长度，如果用str的长度，
                                                    //下标会越界。
                str[i] = "0" + temp[i];
                str[str.length - 1 - i] = "1" + temp[i];
            }
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(getGray(2));
    }
}
