package CourseManagementSystem;

public class Administrator {

    Course [] courses;

    Instructor [] instructors;

    Student [] students;

    public Administrator(Course[] courses, Instructor[] instructors, Student[] students) {
        this.courses = courses;
        this.instructors = instructors;
        this.students = students;
    }
}
