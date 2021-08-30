package by.part10.bridge;

public class Main {

  public static void main(String[] args) {
    Shape square = new Square(new Blue());
    System.out.println(square.draw()); //Square drawn. Color is Blue
    Shape square1 = new Square(new Red());
    System.out.println(square1.draw()); //Square drawn. Color is Red
    Circle circle1 = new Circle(new Red());
    System.out.println(circle1.draw()); //Square drawn. Color is Red
  }
}
