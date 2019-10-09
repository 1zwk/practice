package classes;

import java.util.Scanner;

public class Teacher extends User {
    public Teacher(String id, String name){
        super(id,name);
    }


    @Override
    public void meau() {
        System.out.println("**请选择**");
        System.out.println("** 0.退出 **");
        System.out.println("** 1.上架 **");
        System.out.println("** 2.查阅 **");
        System.out.println("** 3.查阅记录 **");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch(select){
            case 0:return true;
            case 1:
                System.out.println("请上架"); break;
            case 2:
                System.out.println("请查阅"); break;
            case 3:
                System.out.println("请查阅记录"); break;
        }

        return false;
    }
}
