package classes;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public abstract class User {

    private String ID;
    private String name;

    public User(String id, String name) {
        this.ID = id;
        this.name = name;

    }


    public static User login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入ID");
        String id = scanner.nextLine();
        System.out.println("请输入姓名");
        String name = scanner.nextLine();
        System.out.println("请输入身份");
        String role = scanner.nextLine();

        User user ;
        if(role.equals("老师")){
            user = new Teacher(id,name);
        }else if(role.equals("学生")){
            user = new Student(id,name);
        }else{
            throw new Exception("错误角色");
        }
        return user;
    }

    public abstract void meau();

    public abstract boolean input();
}
