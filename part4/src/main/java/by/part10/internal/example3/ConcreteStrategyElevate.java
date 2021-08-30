package by.part10.internal.example3;

public class ConcreteStrategyElevate implements Strategy {

    @Override
    public double execute(int a, int b) {
        System.out.println("Called ConcreteStrategyElevete's execute()");
        return Math.pow(a, b);
    }
}
