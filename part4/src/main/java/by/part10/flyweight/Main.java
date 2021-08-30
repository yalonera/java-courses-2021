package by.part10.flyweight;

import java.awt.Color;
import java.util.Date;

public class Main {

  public static void main(String[] args) {
    execute();
    execute();
  }

  private static void execute() {
    System.out.println(new Date());
    final Vehicle vehicle = VehicleFactory.createVehicle(Color.BLUE);
    System.out.println(new Date());
    vehicle.start();
    System.out.println(new Date());
    vehicle.stop();
    System.out.println(new Date());
  }
}
