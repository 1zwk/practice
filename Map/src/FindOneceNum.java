import java.util.HashMap;
import java.util.Map;

/**
 * 给一个数组，找到一个数组中只出现一次的数。
 */


public class FindOneceNum {
    //用map写
    public static int findOneceNum(int[] numbers){
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : numbers) {
            int c = map.getOrDefault(n, 0);
            map.put(n, c + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int number = entry.getKey();
            int cnt = entry.getValue();
            if(cnt == 2){
                System.out.println(number);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,2,4,6,8,9,2,1};
        findOneceNum(array);
    }



}
