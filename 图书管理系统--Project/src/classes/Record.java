package classes;

import java.util.Date;

public class Record {
    private String userId;
    private String bookISBN;
    private Date borrowAt;

    public Record(String userId, String ISBN) {
        this.userId = userId;
        this.bookISBN = ISBN;
        this.borrowAt = new Date();  //Date() 直接记录当前时间。
    }

    /**
     * 查找
     * @param user
     * @param ISBN
     * @return
     */
    public boolean is(User user, String ISBN) {
        return userId.equals(user.getId())
                && bookISBN.equals(ISBN);
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public Date getBorrowAt() {
        return borrowAt;
    }

    public String getUserId() {
        return userId;
    }
}
