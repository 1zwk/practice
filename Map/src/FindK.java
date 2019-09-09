import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindK {
    private static class StringComparator implements Comparator<String> {


        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    Map<String, Integer> wordToCount(String[] words) {
        Map<String, Integer> wordToCount = new HashMap<>();
       /* for (int i = 0; i < words.length; i++) {
            int c = wordToCount.getOrDefault(words[i], 0);
            wordToCount.put(words[i], c + 1);
        }*/
        for (String word : words) {
            int c = wordToCount.getOrDefault(word, 0);
            wordToCount.put(word, c + 1);
        }
        return wordToCount;
    }

    Map<Integer, List<String>> countToWordList(Map<String, Integer> wordToCount) {
        Map<Integer, List<String>> countToWordList = new HashMap<>();
        for (Map.Entry<String, Integer> e : wordToCount.entrySet()) {
            String word = e.getKey();
            int count = e.getValue();

            List<String> wordList = countToWordList.get(count);
            if (wordList == null) {
                wordList = new ArrayList<>();
                countToWordList.put(count, wordList);
            }
            wordList.add(word);
        }

        return countToWordList;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToCount = wordToCount(words);
        Map<Integer, List<String>> countToWordList = countToWordList(wordToCount);
        Set<Integer> keys = countToWordList.keySet();
        int[] count = new int[keys.size()];
        int i = 0;
        for (int e : keys) {
            count[i++] = e;
        }
        Arrays.sort(count);
        int index = count.length - 1;
        List<String> result = new ArrayList<>();
        int j = 0;
        Comparator<String> comparator = new StringComparator();
        while (j < k) {
            int c = count[index--];
            List<String> wordList = countToWordList.get(c);
            wordList.sort(comparator);//调用比较器的方法；
            if (wordList.size() < k - j) {
                result.addAll(wordList);
                j += wordList.size();
            } else {
                result.addAll(wordList.subList(0, k - j));
                j = k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leedcode", "i", "love", "coding"};
//        BinarySearchTree<String, Integer> map = new FindK().wordToCount(words);
//        System.out.println(new FindK().wordToCount(words));
        List<String> r = new FindK().topKFrequent(words, 1);
        System.out.println(r);

    }
}
