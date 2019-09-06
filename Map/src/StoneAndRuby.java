import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个数组如ruby = {aA}; 在给定一个数组stone = {aaABCd}; 求stone中的宝石数。
 * 规定ruby的字符为宝石，且大小写区分，那么我手中stone数组就有三个宝石。
 */

public class StoneAndRuby {
    public static void numJewe(String J, String S){
        Set<Character> set = new HashSet<>();
        int ruby = 0;
        for(char ch : J.toCharArray()){
            set.add(ch);
        }
        for(char ch : S.toCharArray()){
            if(set.contains(ch)){
                ruby++;
            }
        }
        System.out.println(ruby);

    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aaaBBBBAxdevCv";
        numJewe(J, S);

    }
}
