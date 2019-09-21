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
                        if (special.get(c).contains(next)) {//再判断特殊的key对应的value有无next
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
