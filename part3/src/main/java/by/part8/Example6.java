package by.part8;

import java.util.ArrayList;
import java.util.List;

public class Example6 {

  public interface MyList<T> {

    int count();

    void add(T item);
  }

  public static class MyListImpl<T> implements MyList<T> {

    private List<T> delegate = new ArrayList<>();

    @Override
    public int count() {
      return delegate.size();
    }

    @Override
    public void add(T item) {
      delegate.add(item);
    }
  }

  public static class CustomList<T> implements MyList<T> {

    private List<T> delegate = new ArrayList<>();

    @Override
    public int count() {
      return 0;
    }

    @Override
    public void add(T item) {
      delegate.add(item);
    }
  }

  public static void main(String[] args) {
    MyList<Integer> list1 = new MyListImpl<>();
    list1.add(1);
    System.out.println(list1.count());
    MyList<Integer> list2 = new CustomList<>();
    list2.add(1);
    System.out.println(list2.count());
    System.out.println("list1.count() == list2.count() = " + (list1.count() == list2.count()));
  }
}
