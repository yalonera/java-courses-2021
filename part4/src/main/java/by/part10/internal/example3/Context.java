package by.part10.internal.example3;

public class Context {

    private Strategy strategy;

    // Constructor
    public Context() {
    }

    // Set new strategy
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}
 