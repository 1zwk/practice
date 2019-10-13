package databases;

import classes.Record;
import classes.User;

import java.util.ArrayList;
import java.util.List;

public class RecordShelf {
    private List<Record> RecordList = new ArrayList<>();

    private static RecordShelf recordShelf = new RecordShelf();
    public static RecordShelf getInstance(){
        return recordShelf;
    }

    public boolean contains(User user, String ISBN) {
        for(Record record : RecordList){
            if(record.is(user,ISBN)){
                return true;
            }
        }
        return false;
    }

    public void put(User user, String ISBN) {
        RecordList.add(new Record(user.getId(),ISBN));
    }
}
