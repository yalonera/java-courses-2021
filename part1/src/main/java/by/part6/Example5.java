package by.part6;

import by.part6.Example4.Converter;

public class Example5 {

  public static void main(String[] args) {
    final int num = 1;

    Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

    stringConverter.convert(2);     // 3
  }
}
