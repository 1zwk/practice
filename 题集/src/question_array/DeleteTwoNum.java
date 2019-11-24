package question_array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/f9533a71aada4f35867008be22be5b6e
 * 来源：牛客网
 *
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 *
 *
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 * 示例1
 * 输入
 * 8
 * 输出
 * 6
 */
public class DeleteTwoNum {
    /**
     * 牛客练习：一定要用while（sc.hasNext（））处理多个case；
     *
     * 我的思路：
     * 1.要返回原下边，首先把原下标用map先保存，
     *   但是这道题数组和下标相同，所以只需要返回被删除的最后一位数就好。
     * 2.想要循环遍历数组我想到的是用while循环，
     *   但是因为需要下标操作，所以我只能在while里面加了一层for循环。
     * 3.删数：每次删除数据后list的size会减少，使用for循环的i是原来的下标，所以删除的话会出错。
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int input = sc.nextInt();
            if (input > 1000) {
                input = 999;
            }
            List<Integer> list = new LinkedList<>();
//        Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < input; i++) {
                list.add(i);
//            map.put(list.get(i), i);
            }
            int temp = delete(list);
            System.out.println(temp);
//        System.out.println(map.get(temp));
        }
    }
    //思路有问题，无法控制每次删除完后list下标改变，下一个删除的数不是原本应该删除的数
    public static int delete(List a) {
        int flag = 0;
        int temp = 0;
        while (a.size() > 1) {
            for (int i = 0; i < a.size(); i++) {
                flag++;
                //int k = i;
                if (flag == 3) {
                    flag = 0;
                    temp = Integer.parseInt(a.remove(i).toString());//把Object对象转为int

                }
            }
        }
        return temp;
    }

    /**
     * 大佬思路：这道题想要首尾呼应循环的话可以想到循环队列的公式，使用（i+2）% size()；
     *  这样既解决了循环的问题，又可以让每次删除正确的数（该删除的数：2 5 8，除了第一个是+2，
     *  后面本都应该+3，但是每次i+2就少加了一个，而每次size又会-1，所以刚好契合。）
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n > 1000) {//题目要求大于就=999
                n = 999;
            }
            List<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int i = 0;
            while (list.size() > 1) {
                i = (i + 2) % list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}
