import java.util.*;
/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 */
public class SeachFrequentlyChar {
    public static List<Character> commonChars(String[] A) {
        if (A == null && A.length < 2) {
            return null;
        }
        Map<Character, Integer> result = new HashMap<>();
        for (char e : A[0].toCharArray()) {
            int count = result.getOrDefault(e, 0);
            result.put(e, count + 1);
        }
        //Set<Character> resultSet = result.keySet();

        // Map<Character, Integer> print = new HashMap<>();
        Map<Character, Integer> temp = new HashMap<>();
        for (int i = 1; i < A.length; i++) {

            for (char e : A[i].toCharArray()) {
                int count = temp.getOrDefault(e, 0);
                temp.put(e, count + 1);
            }
            for (char e : temp.keySet()) {
                if (!result.containsKey(e)) {
                    temp.remove(e);
//                    int countTemp = temp.get(e);
//                    int countResult = result.get(e);
//                    int min = Math.min(countResult,countTemp);
//                    print.put(e, min);
                }
            }
        }
        List<Character> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> e : temp.entrySet()) {
            char c = e.getKey();
            int count = e.getValue();

            for (int i = 0; i < count; i++) {
                list.add(c);
            }
        }
        return list;
    }

    //思路：首先使用一个存在map的list把每个单词的map保存，（思考为什么要存进list）
    //然后遍历第一个map的字母和后面的map比较看这个字母是否都存在，
    // 如不存在，跳出该字母的循环，存在就找到他出现的最小次数，
    //最后把字母和出现的次数保存进结果中。
    public static List<Character> commonChars2(String[] A) {
        if (A == null) {
            return null;
        }
        if (A.length <= 1) {
            List<Character> result = new ArrayList<>();
            for (Character c : A[0].toCharArray()) {
                result.add(c);
            }
            return result;
        }
        List<Map<Character, Integer>> list = new ArrayList<>();
        for (String word : A) {
            Map<Character, Integer> map = new HashMap<>();
            for (char a : word.toCharArray()) {
                int n = map.getOrDefault(a, 0);
                map.put(a, 1 + n);
            }
            list.add(map);
        }

        List<Character> result = new ArrayList<>();
        for (char e : list.get(0).keySet()) {
            boolean allSame = true;
            for (int i = 1; i < list.size(); i++) {
                Map<Character, Integer> otherMap = list.get(i);
                if (!otherMap.containsKey(e)) {
                    allSame = false;
                    break;
                }
            }

            if (!allSame) {
                continue;
            }

            int min = list.get(0).get(e);
            for (int i = 1; i < list.size(); i++) {
                int n = list.get(i).get(e);
                if (n < min) {
                    min = n;
                }
            }

            for (int i = 0; i < min; i++) {
                result.add(e);
            }
        }
        return result;
    }

    public static List<String> commonChars3(String[] A) {
        List<int[]> list = new ArrayList<>();
        for (String word : A) {
            int[] a = new int[26];
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                a[index]++;
            }
            list.add(a);
        }

        int[] result = new int[26];
        for (int i = 0; i < 26; i++) {
            int n = Integer.MAX_VALUE;
            for (int[] a : list) {
                n = Math.min(n, a[i]);
                result[i] = n;
            }
        }

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < result[i]; j++) {
                char c = (char) (i + 'a');
                resultList.add(String.valueOf(c));
            }
        }
        return resultList;
    }


    public static void main(String[] args) {
        String[] s = {"bella", "label", "roller"};
        System.out.println(commonChars3(s));

    }

}
