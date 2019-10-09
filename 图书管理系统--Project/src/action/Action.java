package action;

import classes.Books;
import databases.BookShelf;

public class Action {
    public static Books putBook(String ISBN, String title, String writer, Double price, int count){
        BookShelf bookShelf = BookShelf.getIntance();

        try{
            Books book = bookShelf.search(ISBN);
            book.increaseCount(count);
            return book;
        }catch(NoSuchBookException exc){
            Books book = new Books(ISBN,title, writer, price, count);
            bookShelf.putBook(book);
            return book;
        }

    }

}
