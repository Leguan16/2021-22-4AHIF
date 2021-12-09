package app;

import domain.Pizza;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {
        var margerita = new Pizza("Margarita", 21);
        var margeritaLarge = new Pizza("Margarita", 41);
        var tonno = new Pizza("Tonno", 21);
        Stream.of(margeritaLarge, margerita, tonno)
                .sorted((o1, o2) -> Double.compare(o1.diameter(), o2.diameter()))
                .forEach(pizza -> System.out.println(pizza));
        IntStream.range(3,89);
    }
}
