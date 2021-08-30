package by.part10.adapter;

public class Main {

  public static void main(String[] args) {
    Movable bugattiVeyron = new BugattiVeyron();
    System.out.println(bugattiVeyron.getSpeed() + " KMPH");
    MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
    System.out.println(bugattiVeyronAdapter.getSpeed() + "  MPH"); // 431.30312
  }
}
