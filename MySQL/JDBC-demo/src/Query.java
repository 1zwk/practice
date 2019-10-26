
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query {
    public static void main(String[] args) {
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = DataSourceDBUtil.getConnection();
            String sql = "select * from student where qq_mail"
                    + " like ? and classes_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"%qq.com");
            ps.setInt(2,1);
            resultSet = ps.executeQuery();//插入，删除，更新都是用executeUpdate（），返回的是改变的行数（int）。
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                Integer sn = resultSet.getInt("sn");
                System.out.println(String.format("id = %s, sn = %s",id,sn));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataSourceDBUtil.release(resultSet,ps,connection);
        }

    }
}
