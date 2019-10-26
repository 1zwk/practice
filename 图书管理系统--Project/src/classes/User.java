package classes;

import action.Action;
import databases.QueryCondition;
import java.util.Comparator;
import java.util.HashMap;
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

    /**
     * 枚举，每个枚举值是有默认序列值的，根据书写顺序，第一个为0。
     * 之所以在这里使用枚举，是为了代码的已读性和易维护性
     */
    private enum OrderBy{
        OTHER, TITLE , PRICE_ASC, PRICE_DESC, AUTHOR
    }

    /**
     * 创建一个哈希表存储用户的选择对应的结果
     * 在这里就是根据选择来调用不同的比较器
     */
    private static final HashMap<OrderBy, Comparator<Books>> comparators = new HashMap<>();
    static {
        comparators.put(OrderBy.TITLE, new TitleComparator());
        comparators.put(OrderBy.PRICE_ASC, new priceComparator(true));
        comparators.put(OrderBy.PRICE_DESC, new priceComparator(false));
        comparators.put(OrderBy.AUTHOR, new AutherComparator());
    }

    //调用哈希表的方法
    private static Comparator<Books> getComparator(int selected){
        return comparators.get(selected);
    }


    protected void queryBook() {
        //BookShelf bookShelf = Action.querBook();不是直接用BookShelf类型来获取书架，而是使用list，这样才可以去使用循环

       /* BookShelf bookShelf = BookShelf.getInstance();
        List<Books> booksList = bookShelf.queryBooks();*/ //也不这么做，更愿意把每一步都封装进一个方法中

        Scanner sc = new Scanner(System.in);
        System.out.println("请选择");
        System.out.println("1、全查询");
        System.out.println("2、查询存量大于0的");
        System.out.println("其他、根据书名查询");
        int select = sc.nextInt();
        sc.nextLine();
        List<Books> bookShelf;
        switch(select){
            case 1 :
                System.out.println("请选择排序顺序：");
                System.out.println(OrderBy.TITLE.ordinal() + ". 按标题排序");//enum.ordinal()返回它的枚举序列号
                System.out.println("2. 按价格(从低到高)");
                System.out.println("3. 按价格(从高到低)");
                System.out.println("4. 按作者排序");
                System.out.println("其他: 按默认顺序");
                int selected2 = sc.nextInt();
                sc.nextLine();
                bookShelf = Action.queryBooks(getComparator(selected2));break;
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

        List<Record> recordList = Action.queryRecord();
        for(Record record : recordList){
            System.out.printf("ID：%s, 书籍编号%s, 借阅时间%s %n",
                                record.getUserId(),
                                record.getBookISBN(),
                                record.getBorrowAt()
                                                     );
        }
        System.out.println("共查询到" + recordList.size() + "本书");
    }
}
