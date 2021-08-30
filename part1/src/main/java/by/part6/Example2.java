package by.part6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example2 {

  public static void main(String[] args) {
//old style
    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    Collections.sort(names, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        return b.compareTo(a);
      }
    });
//java8 style 1)
    Collections.sort(names, (String a, String b) -> {
      return b.compareTo(a);
    });
//java8 style 2)
    Collections.sort(names, (String a, String b) -> b.compareTo(a));
//java8 style 3)
    Collections.sort(names, (a, b) -> b.compareTo(a));
//java8 style 4)
    Collections.sort(names, Comparator.reverseOrder());

    Collections.sort(names, String::compareTo);
  }
}
