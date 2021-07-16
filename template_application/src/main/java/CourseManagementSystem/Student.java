package CourseManagementSystem;

public class Student implements Lessons{

    int id;

    String name;

    String surname;

    Course course;

    public Student(int id, String name, String surname, Course course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.course = course;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public void read() {
        System.out.println("The student is reading");

    }

    @Override
    public void doCoding() {
        System.out.println("The student is coding");

    }

    @Override
    public void write() {
        System.out.println("The student is writing");

    }
}
