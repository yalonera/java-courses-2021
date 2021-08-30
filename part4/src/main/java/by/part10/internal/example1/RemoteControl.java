package by.part10.internal.example1;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl {

  private List<Command> commands = new ArrayList<>();
  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void pressButton() {
    commands.add(command);
    command.execute();
  }

  public List<Command> getCommands() {
    return commands;
  }

  public void setCommands(List<Command> commands) {
    this.commands = commands;
  }
}