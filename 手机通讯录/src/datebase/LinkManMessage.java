package datebase;

import java.util.ArrayList;
import java.util.List;

public class LinkManMessage {
    private String remark;
    private List<String> numbers = new ArrayList<>();


    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setNumber(String number) {
        numbers.add(number);
    }
}
