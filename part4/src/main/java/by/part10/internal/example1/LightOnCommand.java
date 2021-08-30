package by.part10.internal.example1;

public class LightOnCommand implements Command {

  private final Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  public void execute() {
    if (light.isStatus()) {
      System.out.println("already light on");
    }
    light.switchOn();
  }
}