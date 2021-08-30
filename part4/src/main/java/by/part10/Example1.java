package by.part10;

import by.part10.internal.example1.Command;
import by.part10.internal.example1.CompositeCommand;
import by.part10.internal.example1.Light;
import by.part10.internal.example1.LightOffCommand;
import by.part10.internal.example1.LightOnCommand;
import by.part10.internal.example1.RemoteControl;
import by.part10.internal.example1.TimeWatchCommand;
import java.util.Arrays;

public class Example1 {

  public static void main(String[] args) {
    RemoteControl control = new RemoteControl();
    Light light = new Light();
    //switch on
    Command lightsOn = new LightOnCommand(light);
    control.setCommand(lightsOn);
    control.pressButton();
    control.pressButton();
    control.pressButton();
    control.pressButton();
    control.pressButton();
    //switch off
    Command lightsOff = new LightOffCommand(light);
    control.setCommand(lightsOff);
    control.pressButton();
    control.pressButton();
    control.pressButton();
    control.pressButton();
    control.setCommand(lightsOn);
    control.pressButton();
    final CompositeCommand lightsOnOff = new CompositeCommand(
        Arrays.asList(
            new TimeWatchCommand(new LightOnCommand(light)),
            new LightOffCommand(light)
        )
    );
    control.setCommand(lightsOnOff);
    control.pressButton();

    control.getCommands();

    System.out.println("Is light on? " + (light.isStatus() ? "yes" : "no"));
  }
}
