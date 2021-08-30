package by.part6.homework;

import java.util.Arrays;
import java.util.List;

public class HomeWork1 {

    //Создайте метод который принимает на вход коллекцию чисел, преобразуйте
    // каждое число возведя его в степень двойки
    // и прибавив 10, исключите числа которые больше 50
    // и меньше 10, из оставшихся чисел вычтите 1.
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 4, 2, 5, 7, 3, 8, 9, 10);
        numbers.stream()
                .map(num -> Math.pow(num, 2) + 10)
                .filter(num -> !(num > 50) && !(num < 10))
                .map(num -> num - 1)
                .forEach(System.out::println);
    }
}
