package full.mypostgresql.demo.repository;

import full.mypostgresql.demo.model.Gender;
import full.mypostgresql.demo.model.Student;
import full.mypostgresql.demo.model.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository @Component
public class StudentRepo implements IStudentRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private static final String STUDENT_TABLE_NAME = "student";
    @Override
    public String createStudent(Student student) {
        try {
            String query = String.format("INSERT INTO %s (lastname, firstname, avggrade, gender, classid) VALUES(?,?,?,?,?)", STUDENT_TABLE_NAME);
            jdbcTemplate.update(query, student.getLastName(), student.getFirstName(), student.getAvgGrade(), student.getGender().name(), student.getClassId());

        return null;
        }
        catch (Exception e){
            return "{\"Error\": \"" + e.toString() + "\"}";
        }
    }

    @Override
    public void deleteStudent(Integer id) {
         String query = String.format("DELETE FROM %s WHERE id= ?", STUDENT_TABLE_NAME);
        try {
            jdbcTemplate.update(query, id);
          //  return null;
        }
        catch (EmptyResultDataAccessException  e){
           // return "{\"Error\": \"" + e.toString() + "\" }";
        }
    }

    @Override
    public void updateStudent(Student student, Integer id) {
        String query = String.format("UPDATE %s SET lastName=?, firstName=?, avgGrade=? gender = ? classId = ? WHERE id= ?", STUDENT_TABLE_NAME);
        jdbcTemplate.update(query, student.getLastName(), student.getFirstName(),
                student.getAvgGrade(),student.getGender(), student.getClassId(), id);

    }

    @Override
    public Student getStudentById(Integer id) {
        String query = String.format("Select * from %s where id=?", STUDENT_TABLE_NAME);
        try
        {
            return jdbcTemplate.queryForObject(query, new StudentMapper(), id);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudent() {
        String query = String.format("Select * from %s", STUDENT_TABLE_NAME);
        try {
            return jdbcTemplate.query(query, new StudentMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }


    }
}
