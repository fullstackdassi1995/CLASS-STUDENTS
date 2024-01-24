package full.mypostgresql.demo.service;

import full.mypostgresql.demo.model.ClassRoom;
import full.mypostgresql.demo.model.Student;

import java.util.List;

public interface IClassRoomService {
    String createClassRoom(ClassRoom classRoom);

    void updateClassRoom(ClassRoom classRoom, Integer id);

    void deleteClassRoom(Integer id);

    List<ClassRoom> getAllClassRoom();

    ClassRoom getClassRoomById(Integer id);
}
