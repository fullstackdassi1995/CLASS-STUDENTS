package full.mypostgresql.demo.model;

import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter @Setter
    protected int id;
    @Getter @Setter
    protected String lastName;
    @Getter @Setter
    protected String firstName;
    @Getter @Setter
    protected Float avgGrade;
    @Getter @Setter
    protected Gender gender;
    @Getter @Setter
    protected Integer classId;

    public Student() {
    }

    public Student(int id, String lastName, String firstName, Float avgGrade, Gender gender, int classId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.avgGrade = avgGrade;
        this.gender = gender;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", AvgGrade=" + avgGrade +
                ", gender=" + gender +
                ", classId=" + classId +
                '}';
    }
}
