import java.util.List;

public class Student {
    //数据库定义数据都定义为包装类，int 默认值为 0 ，可以查询。包装类为null。
    private Integer id;
    private Integer sn;
    private String name;
    private String qqMail;
    private Integer classesId;

    private List<Score> scores;

    public Student() {
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Student(Integer id, Integer sn, String name, String qqMail, Integer classesId) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.qqMail = qqMail;
        this.classesId = classesId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sn=" + sn +
                ", name='" + name + '\'' +
                ", qqMail='" + qqMail + '\'' +
                ", classesId=" + classesId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Integer getSn() {
        return sn;
    }

    public String getName() {
        return name;
    }

    public String getQqMail() {
        return qqMail;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQqMail(String qqMail) {
        this.qqMail = qqMail;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }


}
