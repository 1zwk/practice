package classes;

public class Books {
    private int ISBN;
    private String title;
    private String writer;
    private double price;
    private int curCount;
    private int totalCount;

    public Books(String ISBN, String title, String writer, Double price, int count) {
    }


    public boolean is(String ISBN) {
        return this.equals(ISBN);
    }


    public void increaseCount(int count) {
        curCount += count;
        totalCount += count;
    }
}
