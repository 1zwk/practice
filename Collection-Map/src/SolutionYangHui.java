/**
 * 用泛型顺序表写杨辉三角
 */

import java.util.ArrayList;
import java.util.List;

public class SolutionYangHui {
    //思路一：先用尾插把元素插入，都为1，再用set把中间元素修改。
    public List<List<Integer>> generate(int numRows) {
        //创建一个每个元素为顺序表的线性表
        List<List<Integer>> list = new ArrayList<>(numRows);
        //给线性表插入元素
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>(i + 1));
        }
        //给线性表里面的顺序表插入元素。
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                list.get(i).add(1);
            }
        }

        //给顺序表元素赋值
        for (int i = 0; i < numRows; i++) {
            for (int j = 1; j <= i - 1; j++) {
                int n = list.get(i - 1).get(j) + list.get(i - 1).get(j - 1);
                list.get(i).set(j, n);

            }
        }
        return list;
    }

    //思路二：先把前两排元素特殊处理，在进行后续每一排的元素赋值
    public List<List<Integer>> generate2(int numRows){
        List<List<Integer>> list = new ArrayList<>(numRows);// int[] array = new array[];
        for(int i = 0; i < numRows; i++){
            list.add(new ArrayList<>(i+1));
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);

        for(int i = 2; i < numRows; i++){
            list.get(i).add(1);
            for(int j = 1; j < i; j++){
                int n = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                list.get(i).add(j, n);
            }
            list.get(i).add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        SolutionYangHui s = new SolutionYangHui();
        System.out.println(s.generate(5));
        System.out.println(s.generate2(5));
    }
}
