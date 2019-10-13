package classes;

import action.Action;
import exception.*;
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
    public boolean input() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch(select){
            case 0:
                changeUser();break;
            case 1:
                queryBook(); break;
            case 2:
                borrowBook(); break;
            case 3:
                System.out.println("请还书"); break;
            case 4:
                System.out.println("请查阅记录"); break;
        }

        return false;
    }

    private void borrowBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入ISBN");
        String ISBN = sc.nextLine();
        User user = User.getCurUser();
        try{
            Books book = Action.borrowBook(user,ISBN);
            System.out.printf("借阅《%s》成功！%n",book.getTitle());
        }catch(NoSuchBookException e){
            System.out.println("没有该书");
        }catch(BookNotEnoughException e){
            System.out.println("该书已经被借阅完");
        }catch(YetBorrowedException e){
            System.out.println("你已经借阅过该书");
        }
    }



}
