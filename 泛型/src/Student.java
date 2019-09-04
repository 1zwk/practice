import java.util.Arrays;

public class Student implements Comparable<Student> {
    public int age;
    public String name;


    public int getAge() {
        return age;
    }


    @Override
    public int compareTo(Student o) {
        if (this.age < o.age) {
            return -1;
        } else if (this.age > o.age) {
            return 1;
        } else {
            return 0;
        }
    }

    //    @Override
//    public String toString() {
//        return String.format("%d ",Student.age);
//    }
    @Override
    public String toString() {
        return String.format("Person{age=%d}", age);
    }
}


