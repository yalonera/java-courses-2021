package by.part8;

public class Example11 {

  public static class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();
  }

  public static class Singleton2 {

    private static Singleton2 instance;

    public static synchronized Singleton2 getInstance() {
      if (instance == null) {
        instance = new Singleton2();
      }
      return instance;
    }
  }

  public static class Singleton3 {

    public static class SingletonHolder {

      public static final Singleton3 HOLDER_INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
      return SingletonHolder.HOLDER_INSTANCE;
    }
  }
}
