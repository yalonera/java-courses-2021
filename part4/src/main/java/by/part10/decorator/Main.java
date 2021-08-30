package by.part10.decorator;

public class Main {

  public static void main(String[] args) {
    ChristmasTree tree2 = new BubbleLights(new ChristmasTreeImpl());
    System.out.println(tree2.decorate()); //Christmas tree with Bubble Lights
  }
}
