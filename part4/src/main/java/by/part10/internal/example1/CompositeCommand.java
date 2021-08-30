package by.part10.internal.example1;

import java.util.List;

public class CompositeCommand implements Command {

  private final List<Command> commands;

  public CompositeCommand(List<Command> commands) {
    this.commands = commands;
  }

  @Override
  public void execute() {
    commands.forEach(Command::execute);
  }
}