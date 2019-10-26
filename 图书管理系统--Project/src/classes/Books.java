package classes;

public class Books {
    private String ISBN;
    private String title;
    private String writer;
    private double price;
    private int curCount;
    private int totalCount;
    private int borrowedCount;

    /**
     * 构造函数
     *
     * @param ISBN
     * @param title
     * @param writer
     * @param price
     * @param count
     */
    public Books(String ISBN, String title, String writer, Double price, int count) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.writer = writer;
        this.curCount = count;//同下
        this.totalCount = count;//新书还没被借过
        this.borrowedCount = 0;

    }

    public int getTotalCount() {
        return totalCount;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getCurCount() {
        return curCount;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public double getPrice() {
        return price;
    }

    public String getWriter() {
        return writer;
    }

    /**
     * 搜索功能里判断是不是这本书
     *
     * @param ISBN
     * @return
     */
    public boolean is(String ISBN) {
        return this.ISBN.equals(ISBN);
    }

    public void increaseCount(int count) {
        curCount += count;
        totalCount += count;
    }

    public void borrowBook() {
        curCount--;
        borrowedCount++;
    }

    public void returnBook() {
        curCount++;
        borrowedCount++;
    }
}
