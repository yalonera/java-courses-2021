package by.part10.internal.example1;

public class TimeWatchCommand implements Command {

  private final Command command;

  public TimeWatchCommand(Command command) {

    this.command = command;
  }

  public void execute() {
    final long before = System.currentTimeMillis();
    command.execute();
    System.out.println("Executed in " + (System.currentTimeMillis() - before) + " ms");
  }
}