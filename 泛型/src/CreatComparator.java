import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class CreatComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}


