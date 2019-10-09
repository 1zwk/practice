package databases;

import action.NoSuchBookException;
import classes.Books;


import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private List<Books> booksList = new ArrayList<>();

    private static BookShelf bookShelf = new BookShelf();
    public static BookShelf getIntance() {
        return bookShelf;
    }

    public Books search(String ISBN) {
        for(Books e : booksList){
            if(e.is(ISBN)){
                return e;
            }
        }
        return new NoSuchBookException(ISBN);
    }

    public void putBook(Books book) {
        booksList.add(book);
    }
}
