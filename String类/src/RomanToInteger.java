/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 */

import java.util.*;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character,Integer> common = new HashMap<>();
        common.put('I',1);
        common.put('V',5);
        common.put('X',10);
        common.put('L',50);
        common.put('C',100);
        common.put('D',500);
        common.put('M',1000);

        Map<Character,List<Character>> special = new HashMap<>();
        special.put('I',Arrays.asList('V','X'));
        special.put('X',Arrays.asList('L','C'));
        special.put('C',Arrays.asList('D','M'));

        int n = 0;
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(special.containsKey(c)){
                if(i < s.length() - 1 ){
                    char next = s.charAt(i+1);
                    if(special.containsKey(c)) {//先判断c是否在特殊的key中，
                        if (special.get(c).contains(next)) {//再判断特殊的key对应的value有无next，使用的contains不同。
                            int cInt = common.get(c);
                            int nextInt = common.get(next);

                            n += (nextInt - cInt);
                            i++;
                            continue;
                        }
                    }
                }

            }

            int charInt = common.get(c);
            n += charInt;
        }
        return n;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("II"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("V"));
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("VII"));
        System.out.println(romanToInt("VIII"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("X"));
        System.out.println(romanToInt("MCMXCIV"));
    }


}
