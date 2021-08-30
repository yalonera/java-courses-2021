package by.part6.homework;

import java.util.*;
import java.util.stream.Collectors;

//Сгруппировать студентов по специальностям, сохраняя алфавитный порядок специальности,
// а затем сгруппировать по курсу.
public class HomeWork8 {

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

        Map<Speciality, Map<Integer, List<Student>>> result = students.stream()
                .sorted(Comparator
                        .comparing(Student::getSpeciality, Comparator.comparing(Enum::name))
                        .thenComparing(Student::getYear)
                )
                .collect(Collectors.groupingBy(
                        Student::getSpeciality,
                        HashMap::new,
                        Collectors.groupingBy(Student::getYear)));
        result.forEach((s, map) -> {
            System.out.println(s);
            map.forEach((year, list) -> System.out.format("%d: %s%n", year, list.stream()
                    .map(Student::getName)
                    .sorted()
                    .collect(Collectors.joining(", ")))
            );
            System.out.println();
        });
    }
}
