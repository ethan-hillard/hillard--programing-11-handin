public class Main {
    public static void main(String[] args) {
        School school = new School("school", 1234567, true);

        school.addStudent(new Student("yes", "n't", 3));
        school.addStudent(new Student("ian", "lee", 5));
        school.addStudent(new Student("sal", "sam", 5));
        school.addStudent(new Student("stan", "tan", 8));
        school.addStudent(new Student("kevin", "le", 11));
        school.addStudent(new Student("kaden", "wong", 4));
        school.addStudent(new Student("jaden", "ma", 3));
        school.addStudent(new Student("smith", "i ran out of names", 8));
        school.addStudent(new Student("joe", "names are hard to make", 6));
        school.addStudent(new Student("steven", "lastname", 12));

        school.addTeacher(new Teacher("julia", "julia", "language 11"));
        school.addTeacher(new Teacher("woo", "lim", "math 12"));
        school.addTeacher(new Teacher("rebecca", "santos", "science 11"));

        //Prints all of the teachers
        System.out.println("teachers in the school");
        school.printTeachers();

        System.out.println("===============================================");

        //Prints all of the students
        System.out.println("students in the school");
        school.printStudents();

        //Deletes  two students and one teacher
        school.removeTeacher("science 11");
        school.removeStudent(19);
        school.removeStudent(12);

        System.out.println("###############################################");

        //Prints all of the teacher after deleting one teacher
        System.out.println("the teachers left in the school after one leaves");
        school.printTeachers();

        System.out.println("===============================================");

        //Prints all of the students after deleting two students
        System.out.println("students left in the school after two students leave");
        school.printStudents();
    }
}
