package by.part8;

import by.part8.Example6.CustomList;
import by.part8.Example6.MyList;
import by.part8.Example6.MyListImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example7 {

  interface JdbcSettings{
    String url();
  }

  public interface Repository<T> {

    int count();

    void add(T item);
  }

  public static class MyRepositoryImpl<T> implements Repository<T> {

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

  public static void main(String[] args) {
    List<JdbcSettings> settings = Collections.emptyList();
    MyList<Integer> list1 = new MyListImpl<>();
    list1.add(1);
    System.out.println(list1.count());
    MyList<Integer> list2 = new CustomList<>();
    list2.add(1);
    System.out.println(list2.count());
    System.out.println("list1.count() == list2.count() = " + (list1.count() == list2.count()));
  }
}
