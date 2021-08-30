package by.part5.e3multiplesources;

import reactor.core.publisher.Flux;

public class Task8 {

  public static Flux<IceCreamBall> fillIceCreamWaffleBowl(Flux<IceCreamType> clientPreferences,
      Flux<IceCreamBall> vanillaIceCreamStream,
      Flux<IceCreamBall> chocolateIceCreamStream) {
    return clientPreferences.switchMap(type -> {
      switch (type) {
        case VANILLA:
          return vanillaIceCreamStream;
        case CHOCOLATE:
          return chocolateIceCreamStream;
        default:
          return Flux.error(new IllegalArgumentException("Unsupported IceCream Type " + type));
      }
    });
  }

  enum IceCreamType {
    VANILLA, CHOCOLATE
  }

  static class IceCreamBall {

    private final String type;

    public IceCreamBall(String type) {
      this.type = type;
    }

    public static IceCreamBall ball(String type) {
      return new IceCreamBall(type);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      IceCreamBall that = (IceCreamBall) o;

      return type != null ? type.equals(that.type) : that.type == null;
    }

    @Override
    public int hashCode() {
      return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
      return type;
    }
  }
}