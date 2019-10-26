import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DriveManageDBUtil {
    private static String URL = "jdbc:mysql://localhost:3306/test2";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    /**
     * 1.加载驱动
     * 2.获取连接
     * 3.创建对象 Statement
     * 4.执行sql
     * 5.处理结果集 ResultSet
     * 6.释放资源   关闭结果集，命令，连接，正向定义，反向释放
     *
     * @param args
     */

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //加载驱动:通过反射调用该类到jvm里，并加载它的静态属性和静态方法
            Class.forName("com.mysql.jdbc.Driver");//可以不用显式加载

            //建立连接
            //Connection connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            //创建对象
            //Statement statement = connection.createStatement();
            statement = connection.createStatement();

            //执行sql语句
            //ResultSet resultSet = statement.executeQuery(sql);
            String sql = "select*from student";
            resultSet = statement.executeQuery(sql);

            // 处理结果集
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer sn = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String qq_mail = resultSet.getString(4);
                Integer classes = resultSet.getInt(5);
                System.out.println(String.format("id = %s,sn = %s, name = %s," +
                        "qq_mail = %s, classes = %s %n", id, sn, name, qq_mail, classes));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //正向定义，反向释放。
                //由于定义时为空，上面的代码里面还是调用了可能报错的方法，使对象可能为空
                if (resultSet == null) resultSet.close();
                if (statement == null) statement.close();
                if (connection == null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


