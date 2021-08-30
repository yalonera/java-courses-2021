package by.part10.internal.example1;

public class Light {

  private boolean status;

  public void switchOn() {
    status = true;
  }

  public void switchOff() {
    status = false;
  }

  public boolean isStatus() {
    return status;
  }
}