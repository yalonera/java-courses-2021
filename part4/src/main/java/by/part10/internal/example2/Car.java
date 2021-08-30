package by.part10.internal.example2;

import java.util.function.BiFunction;

public class Car {

  public final int wheels;
  public final String color;

  public Car(final int wheels, final String color) {
    this.wheels = wheels;
    this.color = color;
  }

  public static Builder<Car> builder() {
    return new Builder<>(Car::new);
  }

  @Override
  public String toString() {
    return "Car [wheels = " + wheels + ", color = " + color + "]";
  }

  public static class Builder<T> {

    private final BiFunction<Integer, String, T> builder;

    private int wheelsOrZero;
    private String colorOrNull;

    Builder(final BiFunction<Integer, String, T> builder) {
      this.builder = builder;
    }

    public Builder<T> setWheels(final int wheels) {
      wheelsOrZero = wheels;
      return this;
    }

    public Builder<T> setColor(final String color) {
      colorOrNull = color;
      return this;
    }

    public T build() {
      return builder.apply(wheelsOrZero, colorOrNull);
    }
  }
}