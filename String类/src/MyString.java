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
        return Arrays.equals(value,((MyString) s).value);

    }


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
        return s;
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




}
