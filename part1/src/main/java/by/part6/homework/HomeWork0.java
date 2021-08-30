package by.part6.homework;

public class HomeWork0 {


    static class Student {
        private final String firstName;
        private final String lastName;
        private final Double mark;

        public Student(String firstName, String lastName, Double mrk) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.mark = mrk;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Double getMark() {
            return mark;
        }
    }

    @FunctionalInterface
    interface StudentFactory<P extends Student> {
        P create(String firstName, String lastName, Double mark);
    }


    public static void main(String[] args) {

        StudentFactory<Student> studentFactory = Student::new;
        Student student = studentFactory.create("Masha", "Trututu", 10.0);
        if (student.getMark() == 10) {
            System.out.println(student.getFirstName() + " " + "Woow");
        }

    }
}
