package classes;

import action.Action;
import databases.BookShelf;
import databases.QueryCondition;
import databases.RecordShelf;

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

    public String getId() {
        return ID;
    }

    //被继承的菜单
    public abstract void meau();
    //菜单的输入
    public abstract boolean input() throws Exception;

    private static User curUser = null;

    //查询条件：当前数量大于0时
    private static class Current implements QueryCondition<Books>{
        @Override
        public boolean condition(Books books) {
            return books.getCurCount() > 0;
        }
    }
    //查询条件： 根据书名查询
    private static class BookTitle implements QueryCondition<Books>{
        private String title;
        BookTitle(String title){
            this.title = title;
        }
        @Override
        public boolean condition(Books books) {
            return books.getTitle().equals(title);
        }
    }

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

        Scanner sc = new Scanner(System.in);
        System.out.println("请选择");
        System.out.println("1、全查询");
        System.out.println("2、查询存量大于1的");
        System.out.println("其他、根据书名插查询");
        int select = sc.nextInt();
        List<Books> bookShelf;
        switch(select){
            case 1 :
                bookShelf = Action.queryBooks();break;
            case 2:
                bookShelf = Action.queryBooksByCondition(new Current());break;
            //case 3: 为啥这里写case 3 下边的bookShelf会飘红
            default:
                System.out.println("请输入书名");
                String title = sc.nextLine();
                bookShelf = Action.queryBooksByCondition(new BookTitle(title));break;
        }
       // List<Books> bookShelf = Action.queryBooks();
        for(Books book : bookShelf){
            System.out.printf("《%s》,ISBN:%s, 当前存量：%d,借阅次数：%d %n",
                    book.getTitle(),book.getISBN(),book.getCurCount(),book.getBorrowedCount());
        }

        System.out.printf("共查询到 %d 本书", bookShelf.size());
    }

    protected void queryRecord(){

        List<Record> recordShelf = Action.queryRecord();
        for(Record record : recordShelf){
            System.out.printf("ID：%s, 书籍编号%s, 借阅时间%s %n",
                                record.getUserId(),
                                record.getBookISBN(),
                                record.getBorrowAt()
                                                     );
        }
        System.out.println("共查询到" + recordShelf.size() + "本书");
    }

//    登录切换界面
//    protected boolean changeUser() throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println();
//        System.out.println("**请选择**");
//        System.out.println("** 0.退出 **");
//        System.out.println("** 1.重新登录 **");
//        int select = scanner.nextInt();
//        switch (select){
//            case 0:return true;
//            case 1:
//                login(); break;
//        }
//        return false;
//    }

}
