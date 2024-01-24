package full.mypostgresql.demo.service;

import full.mypostgresql.demo.model.ClassRoom;
import full.mypostgresql.demo.model.Student;
import full.mypostgresql.demo.repository.ClassRoomRepo;
import full.mypostgresql.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Value("${maxStudentExtClass}")
    private Integer maxStudentExtClass;

    @Autowired
    private ClassRoomRepo classRoomRepo;



    @Override
    public String createStudent(Student student) {
        System.out.println("5555555");
        System.out.println(student.getId());

//        String typeClass = String.valueOf(classRoomRepo.getClassRoomById(student.getId()));
//        int numStudent = classRoomRepo.
//        ClassRoom classRoom = classRoomRepo.getClassRoomById(student.getId());
//        System.out.println(classRoom);
       // if (classRoom.getTypeClass().equals("EXTERNAL") & classRoom.getNumberOfStudents() >= maxStudentExtClass){
       //     return "{\"Warning\": \"Cannot create more student in externul class room\" }";
     //   }
    //   else {
     //       classRoomRepo.updateClassRoom(classRoom, classRoom.getId());
            return studentRepo.createStudent(student);
     //   }
    }

    @Override
    public void updateStudent(Student student, Integer id) {
        studentRepo.updateStudent(student, id);

    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepo.deleteStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepo.getAllStudent();
    }

    @Override
    public Student getStudentById(Integer id) {

        return studentRepo.getStudentById(id);
    }
}
