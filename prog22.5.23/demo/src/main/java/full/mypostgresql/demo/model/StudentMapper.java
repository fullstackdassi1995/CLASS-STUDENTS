package full.mypostgresql.demo.model;

import org.springframework.jdbc.core.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(
                rs.getInt("id"),
                rs.getString("lastName"),
                rs.getString("firstName"),
                rs.getFloat("avgGrade"),
                Gender.valueOf(rs.getString("gender")),
                rs.getInt("classId"));
    }
}
