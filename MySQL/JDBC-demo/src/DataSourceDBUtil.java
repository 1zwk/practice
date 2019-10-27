import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DataSourceDBUtil {
    private static String URL = "jdbc:mysql://localhost:3306/test2";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";


    //单例模式（静态初始化）
    private static DataSource DATASOURCE = new MysqlDataSource();
    static {
        ((MysqlDataSource) DATASOURCE).setUrl(URL);
        ((MysqlDataSource) DATASOURCE).setUser(USER_NAME);
        ((MysqlDataSource) DATASOURCE).setPassword(PASSWORD);
    }

    /**
     * 创建数据库连接
     * @return
     */
    public static Connection getConnection() {
        try {
            return DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }
    }

    /**
     *
     * 处理结果集
     * @param resultSet
     * @param ps
     * @param connection
     */
    public static void release(ResultSet resultSet,PreparedStatement ps,Connection connection){
        try{

            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(connection != null) connection.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
