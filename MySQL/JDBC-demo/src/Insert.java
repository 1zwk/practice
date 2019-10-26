import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) {
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = DataSourceDBUtil.getConnection();
            String sql = "insert into student(sn, name) values (?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,233309);
            ps.setString(2,"周杰伦");
            int row = ps.executeUpdate();
            System.out.println(row);
            /*executeUpdate() 不会返回结果集，而是int行数，
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                Integer sn = resultSet.getInt("sn");
                System.out.println(String.format("id = %s, sn = %s",id,sn));
            }
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataSourceDBUtil.release(null,ps,connection);
        }
    }
}
