package domain;

import java.util.Comparator;

public record Pizza(String name, double diameter) implements Comparable<Pizza>{

    @Override
    public int compareTo(Pizza o) {
        return Comparator.comparing(Pizza::name)
                .compare(this, o);
    }
}
