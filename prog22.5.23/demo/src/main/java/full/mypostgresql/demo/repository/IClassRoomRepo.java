package full.mypostgresql.demo.repository;

import full.mypostgresql.demo.model.ClassRoom;
import full.mypostgresql.demo.model.Student;

import java.util.List;

public interface IClassRoomRepo {
    String createClassRoom(ClassRoom classRoom);
    void deleteClassRoom(Integer id);
    void updateClassRoom(ClassRoom classRoom, Integer id);
    ClassRoom getClassRoomById(Integer id);
    List<ClassRoom> getAllClassRoom();
}
