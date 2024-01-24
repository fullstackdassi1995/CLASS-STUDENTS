package full.mypostgresql.demo.service;
import full.mypostgresql.demo.service.ClassRoomService;
import full.mypostgresql.demo.model.ClassRoom;
import full.mypostgresql.demo.model.Student;
import full.mypostgresql.demo.repository.ClassRoomRepo;
import full.mypostgresql.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService{
    @Autowired
    private ClassRoomRepo classRoomRepo;

    @Value("${maxStudentExtClass}")
    private Integer maxStudentExtClass;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String createClassRoom(ClassRoom classRoom) {
        classRoomRepo.createClassRoom(classRoom);
        return "========";
    }

    @Override
    public void updateClassRoom(ClassRoom classRoom, Integer id) {
        classRoomRepo.updateClassRoom(classRoom, id);
    }

    @Override
    public void deleteClassRoom(Integer id) {
        classRoomRepo.deleteClassRoom(id);
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
       return new ArrayList<ClassRoom>(classRoomRepo.getAllClassRoom());
    }

    @Override
    public ClassRoom getClassRoomById(Integer id) {
        return classRoomRepo.getClassRoomById(id);

    }
}
