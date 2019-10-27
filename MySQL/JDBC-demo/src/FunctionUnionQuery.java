import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FunctionUnionQuery {
    public static void main(String[] args) {
        FunctionUnionQuery textQuery = new FunctionUnionQuery();

        textQuery.QueryStudent(60,1);
    }

    public List<Score> QueryStudent(Integer score, Integer classesId) {
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        Connection connection = null;
        List<Score> scores = new ArrayList<>();
        try {
            connection = DataSourceDBUtil.getConnection();
            String sql = "SELECT" +
                    " stu.id," +
                    " stu.NAME student_name," +
                    " cou.NAME course_name," +
                    " sco.score " +
                    "FROM" +
                    " score sco" +
                    " JOIN student stu ON sco.student_id = stu.id" +
                    " JOIN course cou ON sco.course_id = cou.id " +
                    " WHERE" +
                    " score > ? " +
                    " AND stu.classes_id = ?;";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, score);
            ps.setInt(2, classesId);
            resultSet = ps.executeQuery();//插入，删除，更新都是用executeUpdate（），返回的是改变的行数（int）。
            while (resultSet.next()) {
                Score score0 = new Score();
                //把student的书信设置为 resultSet结果集 中的数据，
                score0.setStudent_id(resultSet.getInt("id"));
                score0.setStudent_name(resultSet.getString("student_name"));
                score0.setCourse_name(resultSet.getString("course_name"));
                score0.setScore(resultSet.getBigDecimal("score"));
                scores.add(score0);
//                Integer id = resultSet.getInt("id");
//                Integer sn = resultSet.getInt("sn");
                System.out.println(score0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceDBUtil.release(resultSet, ps, connection);
        }
        return scores;
    }
}
