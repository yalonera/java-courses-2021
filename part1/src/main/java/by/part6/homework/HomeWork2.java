package by.part6.homework;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class HomeWork2 {

    //Создайте метод который принимает на вход коллекцию строк, отфильтруйте только те длинна который не больше 5 символов
    //оставшиеся соедините через запятую и выведите на экран
    public static void main(String[] args) {

        List<String> stringCollection = Arrays.asList(
                "ddd2",
                "aaa2",
                "bbb1",
                "aaa1",
                "bbb3",
                "ccc",
                "bbb2",
                "ddd1",
                "cddd1"
        );

        Optional<String> reduced = stringCollection.stream()
                .filter(str -> str.length() <= 5)
                .reduce((str1, str2) -> str1 + "," + str2);
        reduced.ifPresent(System.out::println);

    }
}
