package classes;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Student extends User {
    public Student(String id, String name){
        super(id,name);
    }

    @Override
    public void meau() {
        System.out.println("**请选择**");
        System.out.println("** 0.退出 **");
        System.out.println("** 1.查阅书籍 **");
        System.out.println("** 2.借书 **");
        System.out.println("** 3.还书 **");
        System.out.println("** 4.查阅记录");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch(select){
            case 0:return true;
            case 1:
                System.out.println("请查阅书籍"); break;
            case 2:
                System.out.println("请借书"); break;
            case 3:
                System.out.println("请还书"); break;
            case 4:
                System.out.println("请查阅记录"); break;
        }

        return false;
    }
}
