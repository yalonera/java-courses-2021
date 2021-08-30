package by.part6.homework;

import java.util.Arrays;
import java.util.List;

// Проверить, есть ли третьекурсники среди учащихся всех специальностей кроме Physics и ComputerScience.
public class HomeWork9 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alex", Speciality.Physics, 1),
                new Student("Rika", Speciality.Biology, 4),
                new Student("Julia", Speciality.Biology, 2),
                new Student("Steve", Speciality.History, 4),
                new Student("Mike", Speciality.Finance, 1),
                new Student("Hinata", Speciality.Biology, 2),
                new Student("Richard", Speciality.History, 1),
                new Student("Kate", Speciality.Psychology, 2),
                new Student("Sergey", Speciality.ComputerScience, 4),
                new Student("Maximilian", Speciality.ComputerScience, 3),
                new Student("Tim", Speciality.ComputerScience, 5),
                new Student("Ann", Speciality.Psychology, 1)
        );
        System.out.println(
                students.stream()
                        .anyMatch(student -> (student.getSpeciality() != Speciality.ComputerScience
                                && student.getSpeciality() != Speciality.Physics) && student.getYear() == 3));

    }
}
