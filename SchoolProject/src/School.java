import java.util.ArrayList;

public class School {
    private String name = new String();
    private int location;
    private boolean Private;

    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    //Constructor to initialize fields
    School(String name, int location, boolean Private){
        this.name = name;
        this.location = location;
        this.Private = Private;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(String subject) {
        for(int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).getSubject().equals(subject)){
                teachers.remove(i);
                break;
            }
        }
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(int studentNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNumber() == studentNumber) {
                students.remove(i);
                break;
            }
        }
    }
        public void printTeachers(){
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println(teachers.get(i).toString());
            }
        }
        public void printStudents(){
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).toString());
            }
        }
    //Getters and Setters
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setlocation(int location) {
        location = location;
    }
    public int getlocation(int location) {
        return location;
    }
    public boolean getPrivate(boolean Private) {
        return Private;
    }
    public void setPrivate(boolean aPrivate) {
        Private = aPrivate;
    }
}
