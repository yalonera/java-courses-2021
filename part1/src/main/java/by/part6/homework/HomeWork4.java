package by.part6.homework;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HomeWork4 {

    //Напишите метод который на вход принмает строку (в которой находятся только слова разделенные пробелом) и возвращает
    // самое популярное слово в этой строке
    public static void main(String[] args) {
        String text = "A kitten is a juvenile cat. After being born, kittens display primary altriciality and are totally dependent on their mother " +
                "for survival. They do not normally open their eyes until after seven to ten days. After about two weeks, kittens quickly develop and " +
                "begin to explore the world outside the nest. After a further three to four weeks, they begin to eat solid food and grow adult teeth. " +
                "Domestic kittens are highly social animals and usually enjoy human companionship.";

        String word = Arrays.stream(text.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println(word);
    }
}
