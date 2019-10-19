import classes.User;

import java.util.Scanner;

/*
1.还书
    为什么要检查有无这本书，记录里面有应该就有
    因为没有记录有两种情况，一个是没被借过，而是他输入的有错误。
2.查询记录
 */
public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            User currentUser = User.login();
            boolean isQuit;
            do {
                currentUser.meau();
                isQuit = currentUser.input();
            } while (!isQuit);
            Scanner sc = new Scanner(System.in);
            System.out.println("1.退出");
            System.out.println("2.切换用户");
            int selected = sc.nextInt();
            sc.nextLine();
            if(selected == 1){ break;}

        }
    }


}
