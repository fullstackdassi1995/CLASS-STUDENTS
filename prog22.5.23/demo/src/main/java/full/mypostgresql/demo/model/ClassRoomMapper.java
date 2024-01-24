package full.mypostgresql.demo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassRoomMapper implements RowMapper<ClassRoom> {

    @Override
    public ClassRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ClassRoom(
                rs.getInt("id"),
                rs.getInt("numberOfStudent"),
                rs.getFloat("classAvg")
                //TypeClassRoom.valueOf(rs.getString("typeClass"))
        );
    }
}
