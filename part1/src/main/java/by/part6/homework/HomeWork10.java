package by.part6.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Увеличить значение курса на 1 если студен учиться на специальности History, на 2 если на Biology
// и на 3 если на Physics, исключить из списка студентов оставшихся специальностей
public class HomeWork10 {

    static List<Student> students = Arrays.asList(
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

    public static void main(String[] args) {
        Map<Speciality, Integer> map = new HashMap<>();
        map.put(Speciality.History, 1);
        map.put(Speciality.Biology, 2);
        map.put(Speciality.Physics, 3);
        students
                .stream()
                .filter(x -> map.keySet().contains(x.getSpeciality()))
                .map(x -> new Student(x.getName(), x.getSpeciality(),
                        x.getYear() + map.get(x.getSpeciality())
                ))
                .forEach(System.out::println);
    }
}
