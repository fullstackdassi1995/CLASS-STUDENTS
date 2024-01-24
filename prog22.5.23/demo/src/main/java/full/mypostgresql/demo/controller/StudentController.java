package full.mypostgresql.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import full.mypostgresql.demo.model.Student;
import full.mypostgresql.demo.service.ClassRoomService;
import full.mypostgresql.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.TypeElement;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ObjectMapper objectMapper;

  //  @Autowired
    //private ClassRoomService classRoomService;

    @CrossOrigin()
    @GetMapping()
    public List<Student> get()
    {
        try {
            return studentService.getAllStudents();
        }
        catch (Exception e){
            return null;
        }
    }
    @CrossOrigin(origins = "http://localhost:8084")
    @GetMapping(value ="/{id}")
    public ResponseEntity getById(@PathVariable Integer id)
    {
        try {
            Student result = studentService.getStudentById(id);
            if (result != null) {
                return new ResponseEntity<Student>(result, HttpStatus.OK);
            }
            return new ResponseEntity<String>("{ \"Warning\": \"not found student with Id " + id + "\" }",
                    HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<String>("{ \"Error\": \"" + e.toString() + "\" }",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping()
//    public ResponseEntity<String> post(@RequestBody Student student) throws JsonProcessingException {
//        System.out.println(student);
//
//
//        String json = objectMapper.writeValueAsString(student);
//        System.out.println("============");
//        Student c = objectMapper.readValue(json, Student.class);
//        System.out.println(c);
//        String result = studentService.createStudent(student);
//        if (result == null) {
//            return new ResponseEntity<String>("{ \"result\": \"created\" }", HttpStatus.CREATED);
//        }
//        return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
//    }

    @PostMapping()
    public ResponseEntity<String> post(@RequestBody Student student) throws JsonProcessingException {
        System.out.println(student);
      String json = objectMapper.writeValueAsString(student);
        System.out.println("============");
        Student c = objectMapper.readValue(json, Student.class);

        String result = studentService.createStudent(student);
        System.out.println(c );
        if (result == null) {
            return new ResponseEntity<String>("{ \"result\": \"created\" }", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
    }




    @PutMapping(value = "/{id}")
    public Student put(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateStudent(student, id);
        return student;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id)
    {
        studentService.deleteStudent(id);
    }

}
