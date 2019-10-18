package databases;

import classes.Record;
import classes.User;
import exception.NotBorrowedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordShelf {
    private List<Record> RecordList = new ArrayList<>();

    private static RecordShelf recordShelf = new RecordShelf();

    public static RecordShelf getInstance() {
        return recordShelf;
    }

    public boolean contains(User user, String ISBN) {
        for (Record record : RecordList) {
            if (record.is(user, ISBN)) {
                return true;
            }
        }
        return false;
    }

    public void put(User user, String ISBN) {
        RecordList.add(new Record(user.getId(), ISBN));
    }

    public void remove(User user, String ISBN) throws NotBorrowedException {
        Iterator<Record> iterator = RecordList.iterator();
        int flag = -1;
        while (iterator.hasNext()) {
            Record record = iterator.next();
            if (record.is(user, ISBN)) {
                iterator.remove();
                flag = 1;
            }
        }
        if (flag == -1) {
            throw new NotBorrowedException();
        }
    }

    public List<Record> queryRecord(QueryCondition queryCondition) {//接口直接当做参数传进去
        List<Record> list = new ArrayList<>();
        for(Record record : RecordList){
            if(queryCondition == null || queryCondition.condition(record)){
                list.add(record);
            }
        }
        return list;
    }




        /*int index = -1;
        for(int i = 0; i< RecordList.size(); i++){
            Record record  = RecordList.get(i);
            if(record.is(user,ISBN)){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw new NotBorrowedException();
        }
        */


}
