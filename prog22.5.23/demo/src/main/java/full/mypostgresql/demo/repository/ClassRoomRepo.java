package full.mypostgresql.demo.repository;

import full.mypostgresql.demo.service.ClassRoomService;

import full.mypostgresql.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class ClassRoomRepo implements IClassRoomRepo{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private static final String CLASSROOM_TABLE_NAME = "classRoom";
    @Override
    public String createClassRoom(ClassRoom classRoom) {
        try {
            String query = String.format("INSERT INTO %s (numberOfStudent, classAvg, typeClassEnum) VALUES (?, ?, ?)", CLASSROOM_TABLE_NAME);
            jdbcTemplate.update(query, classRoom.getNumberOfStudents(), classRoom.getClassAvg(),
                    classRoom.getTypeClass());
            return null;
        }
        catch (Exception e){
            return "{\"Error\": \"" + e.toString() + "\"}";
        }
    }

    @Override
    public void deleteClassRoom(Integer id) {
        String query = String.format("DELETE FROM %s WHERE id= ?", CLASSROOM_TABLE_NAME);
        try {
            jdbcTemplate.update(query, id);
            //  return null;
        }
        catch (EmptyResultDataAccessException e){
            // return "{\"Error\": \"" + e.toString() + "\" }";
        }
    }



    @Override
    public void updateClassRoom(ClassRoom classRoom, Integer id) {
        String queryForAvg = String.format("[select avg(avgGrade) from student where id = ?]");
        String queryForCount = String.format("[select count(*) from student where id =?]");
        String query = String.format("UPDATE %s SET numberOfStudent=?, classAvg=?, typeClassEnum=? WHERE id= ?", CLASSROOM_TABLE_NAME);
        jdbcTemplate.update(query, queryForCount, queryForAvg,
                classRoom.getTypeClass(), id);
    }

    @Override
    public ClassRoom getClassRoomById(Integer id) {
        String query = String.format("Select * from %s where id=?", CLASSROOM_TABLE_NAME);
        try
        {
            return jdbcTemplate.queryForObject(query, new ClassRoomMapper(), id);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        String query = String.format("SELECT id FROM %s", CLASSROOM_TABLE_NAME);
        try {
            return jdbcTemplate.queryForList(query, ClassRoom.class);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    public void updateClass(){

    }

//    public ClassRoom getClassByIdStudent(Integer id){
//        String query = String.format("SELECT * FROM %s WHERE id=?", CLASSROOM_TABLE_NAME);
//        try {
//            return jdbcTemplate.queryForObject(query, new ClassRoomMapper(), id);
//        }
//        catch (Exception e){
//            return null;
//        }
//    }
}
