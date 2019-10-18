package databases;

import exception.NoSuchBookException;
import classes.Books;


import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private List<Books> booksList = new ArrayList<>();

    //单例模式（每次取就取得是唯一的内个对象
    private static BookShelf bookShelf = new BookShelf();//通过声明为静态属性，使他只在类加载的时候加载一次
    public static BookShelf getInstance() {
        return bookShelf;
    }

    public Books search(String ISBN) throws NoSuchBookException {
        for(Books book : booksList){
            if(book.is(ISBN)){
                return book;
            }
        }
        throw new NoSuchBookException(ISBN);
    }

    public void putBook(Books book) {
        booksList.add(book);
    }

    public List<Books> queryBooks(QueryCondition queryCondition) {
        List<Books> list = new ArrayList<>();
        for(Books book : booksList){
            if(queryCondition == null || queryCondition.condition(book)){
                list.add(book);
            }
        }
        return list;
    }
}
