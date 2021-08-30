package by.part6.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HomeWork3 {

    //Есть Map'а чисел, нужно найти сумму всех ключей и всех значений у этой Map'ы.
    public static void main(String[] args) {
        final Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            map.putIfAbsent(i, random.nextInt(100));
        }
        test01(map);
        test02(map);
    }

    private static void test02(Map<Integer, Integer> map) {
        final int sum = map
                .entrySet()
                .stream()
                .mapToInt(x -> x.getKey() + x.getValue())
                .sum();
        System.out.println(sum);
    }

    private static void test01(Map<Integer, Integer> map) {
        final int sumKey = map
                .keySet()
                .stream()
                .mapToInt(x -> x)
                .sum();
        final int sumValue = map
                .values()
                .stream()
                .mapToInt(x -> x)
                .sum();
        System.out.println(map);
        System.out.println(sumKey + sumValue);
    }
}
