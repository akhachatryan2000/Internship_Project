package CourseManagementSystem;

public class Instructor {

    String name;

    Student [] students;

    Course course;

    public Instructor(String name, Student[] students, Course course) {
        this.name = name;
        this.students = students;
        this.course = course;
    }
}
