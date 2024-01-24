package full.mypostgresql.demo.repository;

import full.mypostgresql.demo.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IStudentRepo {
    String createStudent(Student student);
    void deleteStudent(Integer id);
    void updateStudent(Student student, Integer id);
    Student getStudentById(Integer id);
    List<Student> getAllStudent();
}
