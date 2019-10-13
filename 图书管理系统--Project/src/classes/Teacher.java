package classes;

import action.Action;

import java.util.Scanner;

public class Teacher extends User {
    public Teacher(String id, String name){
        super(id,name);
    }


    @Override
    public void meau() {
        System.out.println();
        System.out.println("**请选择**");
        System.out.println("** 0.退出 **");
        System.out.println("** 1.上架 **");
        System.out.println("** 2.查阅 **");
        System.out.println("** 3.查阅记录 **");
    }

    @Override
    public boolean input() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch(select){
            case 0:
                changeUser(); break;
            case 1:
                putBook(); break;
            case 2:
                queryBook(); break;
            case 3:
                System.out.println("请查阅记录"); break;
        }

        return false;
    }

    private void putBook() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入ISBN: ");
        String ISBN = s.nextLine();
        System.out.println("请输入title：");
        String title = s.nextLine();
        System.out.println("请输入writer：");
        String writer = s.nextLine();
        System.out.println("请输入price：");
        double price = s.nextDouble();
        System.out.println("请输入count：");
        int count = s.nextInt();

        Books book = Action.putBook(ISBN,title,writer,price,count);
        System.out.printf("《%s》上架成功 %n",book.getTitle());
    }
}
