package classes;

public class Books {
    private String ISBN;
    private String title;
    private String writer;
    private double price;
    private int curCount;
    private int totalCount;
    private int borrowedCount;

    public int getTotalCount() {
        return totalCount;
    }

    public Books(String ISBN, String title, String writer, Double price, int count) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.writer = writer;
        this.curCount = count;//同下
        this.totalCount = count;//新书还没被借过
        this.borrowedCount = 0;

    }


    public boolean is(String ISBN) {
        return this.ISBN.equals(ISBN);
    }


    public void increaseCount(int count) {
        curCount += count;
        totalCount += count;
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

    public void borrowBook() {
        curCount--;
        borrowedCount++;
    }

    public void returnBook() {
        curCount++;
        borrowedCount++;
    }
}
