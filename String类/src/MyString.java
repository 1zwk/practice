import java.util.*;

public final class MyString  implements Comparable<MyString> {
    private final char[] value;

    public MyString(char[] value){
        this.value = Arrays.copyOf(value,value.length);
    }
    public MyString(char[] value, int offset, int count){
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    public MyString(MyString s){
        this.value = s.value;
    }


    @Override
    public boolean equals(Object s){
        if(this == s){
            return true;
        }
        if(s == null){
            return false;
        }
        //利用反射写  s.getClass() == getClass();
        if(!(s instanceof MyString)){
            return false;
        }
        return Arrays.equals(value.((MyString) s).value);

    }

    private char[] value;
    public MyString toUpper(){
        //char[] copy = Arrays.copyOf(value, value.length);
        MyString s = new MyString(value);
//        for(char c : copy){
//            c = (char)(c + ('A'- 'a'));
//        }
        for(int i = 0; i< s.value.length; i++){
            if(s.value[i] >= 'a' && s.value[i] <= 'z'){

            }
        }

    }



    @Override
    public int compareTo(MyString o) {
        if(o == null){
            return 1;
        }
        int length = Math.min(value.length, o.value.length);
        for(int i = 0; i< length ; i++){
            char a = value[i];
            char b = o.value[i];
            if(a == b){
                continue;
            }
            if(a >= 'a' && a <= 'z'){
                a += ('A' - 'a');
                if(a == b){
                    continue;
                }
            }else if(a >= 'A' && a<= 'Z'){
                a += ('a' - 'A');
                if(a == b){
                    continue;
                }
            }
            return
        }
        if(value.length < o.value.length){
            return 1;
        }else if(value.length > o.value.length){
            return -1;
        }else if(value.length == o.value.length){
            return 0;
        }

        return -1;
    }


    //切割数组
    public MyString substring(int begin, int end) {
        return new MyString(value, begin,end - begin);
    }



    public int romanToInt(String s) {
        Map<Character,Integer> common = new HashMap<>();
        common.put('I',1);
        common.put('V',5);
        common.put('X',10);
        common.put('L',50);
        common.put('C',100);
        common.put('D',500);
        common.put('M',1000);

        Map<Character, char[]> special = new HashMap<>();


        for(int i = 0; i < s.length() - 1; i++){
           common.containsKey( s.charAt(i));
        }


    }
}
