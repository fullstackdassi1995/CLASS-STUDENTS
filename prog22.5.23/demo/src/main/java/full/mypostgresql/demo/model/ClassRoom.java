package full.mypostgresql.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class ClassRoom {
    @Getter @Setter
    protected Integer id;
    @Getter @Setter
    protected Integer numberOfStudents;
    @Getter @Setter
    protected Float classAvg;
    @Getter @Setter
    protected Enum<TypeClassRoom> typeClass;
    protected Random random;

    public ClassRoom() {
    }

    public ClassRoom(int id, int numberOfStudent, Float classAvg) {
        this.id = id;
        this.numberOfStudents = numberOfStudent;
        this.classAvg = classAvg;
        if (random.nextBoolean()){
            this.typeClass = TypeClassRoom.EXTERNAL;
        }
        else this.typeClass = TypeClassRoom.REGULAR;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", numberOfStudent=" + numberOfStudents +
                ", classAvg=" + classAvg +
                ", typeClassEnum=" + typeClass +
                '}';
    }
}
