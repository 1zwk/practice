import java.util.*;
/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。

 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 */
public class SeachFrequentlyChar implements Comparable<Character>{
    public List<String> commonChars(String[] A) {
     Map<Character, Integer> result = new HashMap<>();
     for(char e : A[0].toCharArray()){
         int count = result.getOrDefault(e, 0);
         result.put(e, count + 1);
     }
     for(int i = 1; i < A.length; i++ ){
         Map<Character, Integer> temp = new HashMap<>();
         for(char e : A[i].toCharArray()){
             int count = result.getOrDefault(e, 0);
             temp.put(e, count + 1);
         }
         //比较两个map中的key是否相同，相同把更小的放到result中。

     }


    }

    @Override
    public int compareTo(Character o) {
        if()
    }
}
