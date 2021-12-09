package trains.domain;

import lombok.*;
import lombok.experimental.Delegate;

import java.util.Optional;

@AllArgsConstructor
@ToString
@Builder
public class Car {

    Long id;
    String model;
    String brand;
    NavigationSystem navigationSystem;
    @Delegate
    Engine engine;
    int doors;

    public static void main(String[] args) {
        Car car = new CarBuilder()
                .brand("Mercedes")
                .doors(3)
                .model("E")
                .build();
        System.out.println(car);
        foo();
    }

    @SneakyThrows
    public static void foo() {
        throw new InterruptedException("aaaa");
    }

    public Optional<NavigationSystem> getNavigationSystem() {
        return Optional.ofNullable(navigationSystem);
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Car car = (Car) o;

        return id == null ? false : id.equals(car.id);
    }


    private static class NavigationSystem {

    }

    @Value
    private static class Engine {
        int powerInKwh;
    }
}
