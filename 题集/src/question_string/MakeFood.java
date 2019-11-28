package question_string;

import java.util.HashSet;
import java.util.Scanner;

/*
链接：https://www.nowcoder.com/questionTerminal/ca5c9ba9ebac4fd5ae9ba46114b0f476
来源：牛客网

输入描述:
每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。


输出描述:
输出一行一个数字表示完成所有料理需要多少种不同的材料。
示例1
输入
BUTTER FLOUR
HONEY FLOUR EGG
输出
4
 */
public class MakeFood {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] arr = input.split(" ");
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
        /*两个问题
        1.输入的不是一行怎么解决
        scanner 中有迭代器，可以使用while(hasNext())来判断是否还有下一行输出
        2.split分割的字符串怎么添加到set里
        分割后返回的就是一个String[]，直接创建一个String[] 来保存就可以。
         */
           /*
        问题1.如何把List转为int[];
        2.List<List<>> 呢？
         */
    }
}
