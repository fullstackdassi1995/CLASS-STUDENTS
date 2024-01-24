package full.mypostgresql.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import full.mypostgresql.demo.model.ClassRoom;
import full.mypostgresql.demo.model.Student;
import full.mypostgresql.demo.service.ClassRoomService;
import full.mypostgresql.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classroom")
public class ClassRoomController {

    @Autowired
    ClassRoomService classRoomService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping
    public List<ClassRoom> get()
    {
        return classRoomService.getAllClassRoom();
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity getById(@PathVariable Integer id)
    {
        try {
            ClassRoom result = classRoomService.getClassRoomById(id);
            if (result != null) {
                return new ResponseEntity<ClassRoom>(result, HttpStatus.OK);
            }
            return new ResponseEntity<String>("{ \"Warning\": \"not found student with Id " + id + "\" }",
                    HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<String>("{ \"Error\": \"" + e.toString() + "\" }",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<String> post(@RequestBody ClassRoom classRoom) throws JsonProcessingException {
        //String json = objectMapper.writeValueAsString(student);
        //System.out.println(json);
        //Student c = objectMapper.readValue(json, Student.class);
        // System.out.println(c);
        String result = classRoomService.createClassRoom(classRoom);
        if (result == null) {
            return new ResponseEntity<String>("{ \"result\": \"created\" }", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{id}")
    public ClassRoom put(@PathVariable Integer id, @RequestBody ClassRoom classRoom) {
        classRoomService.updateClassRoom(classRoom, id);
        return classRoom;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id)
    {
        classRoomService.deleteClassRoom(id);
    }

}