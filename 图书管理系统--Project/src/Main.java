import classes.User;

/*
1.还书
    为什么要检查有无这本书，记录里面有应该就有
    因为没有记录有两种情况，一个是没被借过，而是他输入的有错误。
2.查询记录
 */
public class Main {
    public static void main(String[] args) throws Exception {
        User currentUser = User.login();
        boolean isQuit;
        do {
            currentUser.meau();
            isQuit = currentUser.input();
        } while (!isQuit);
        System.out.println("欢迎下次光临");
    }
}
