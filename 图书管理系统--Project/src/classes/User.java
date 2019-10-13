package classes;

import action.Action;
import databases.BookShelf;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.Scanner;

public abstract class User {

    private String ID;
    private String name;

    public User(String id, String name) {
        this.ID = id;
        this.name = name;

    }

    protected static User getCurUser() {
        return curUser;
    }

    public abstract void meau();

    public abstract boolean input() throws Exception;

    private static User curUser = null;

    public static User login() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入ID");
        String id = scanner.nextLine();
        System.out.println("请输入姓名");
        String name = scanner.nextLine();
        System.out.println("请输入身份");
        String role = scanner.nextLine();

        /*User user; //虽然抽象类不能直接new对象，但可以先声明变量，
        // 然后通过用户的输入来new实现这个类的子类对*/
        if (role.equals("老师")) {
            curUser = new Teacher(id, name);
        } else if (role.equals("学生")) {
            curUser = new Student(id, name);
        } else {
            throw new Exception("错误角色");
        }
        return curUser;
    }

    protected void queryBook() {
        //BookShelf bookShelf = Action.querBook();不是直接用BookShelf类型来获取书架，而是使用list，这样才可以去使用循环

       /* BookShelf bookShelf = BookShelf.getInstance();
        List<Books> booksList = bookShelf.queryBooks();*/ //也不这么做，更愿意把每一步都封装进一个方法中
        List<Books> bookShelf = Action.queryBooks();
        for(Books book : bookShelf){
            System.out.printf("《%s》,ISBN:%s, 当前存量：%d,借阅次数：%d %n",
                    book.getTitle(),book.getISBN(),book.getCurCount(),book.getBorrowedCount());
        }
        System.out.printf("共查询到 %d 本书", bookShelf.size());
    }


    public String getId() {
        return ID;
    }


    protected boolean changeUser() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("**请选择**");
        System.out.println("** 0.退出 **");
        System.out.println("** 1.重新登录 **");
        int select = scanner.nextInt();
        switch (select){
            case 0:return true;
            case 1:
                login(); break;
        }
        return false;
    }
}
