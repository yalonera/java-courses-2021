package by.part10.observer;

public class Main {

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }

  public static void test1() {

    NewsAgency observable = new NewsAgency();
    NewsChannel observer = new NewsChannel();

    observable.addObserver(observer);

    observable.setNews("news");
    System.out.println("test1: " +  observer.getNews()); //news"
  }

  public static void test2() {

    ONewsAgency observable = new ONewsAgency();
    ONewsChannel observer = new ONewsChannel();

    observable.addObserver(observer);

    observable.setNews("news");
    System.out.println("test2: " +  observer.getNews()); //news"
  }

  public static void test3() {

    PCLNewsAgency observable = new PCLNewsAgency();
    PCLNewsChannel observer = new PCLNewsChannel();

    observable.addPropertyChangeListener(observer);

    observable.setNews("news");
    System.out.println("test3: " +  observer.getNews()); //news"
  }
}
