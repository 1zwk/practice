import java.util.Arrays;

enum Gender{
    female, male;
}


public class enumDemo {
    public static void main(String[] args) {
        Gender gender = Gender.female;
        System.out.println(gender);
        //枚举方法  ,打印所有的枚举常量。
        System.out.println(Arrays.toString(Gender.values()));

        String i = "是";
        String u = "d";
        if(i.equals(u)){

        }
    }

}
