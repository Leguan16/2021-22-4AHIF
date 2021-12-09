package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.*;

public class Wiederholung {

    public static void main(String[] args) {
        try (Stream<String> lineStream = Files.lines(Path.of("some.txt"))) {
            int sum = lineStream
                    .filter(s -> false)
                    .mapToInt(String::length)
                    .sum();
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }

        IntStream
                .range(0,20)
                .boxed();



    }
}
