package erni.example.jfr.brackets;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        BracketValidator validator = new BracketValidator();
        List<String> testValues = generateTestValues();

        System.out.println("Setup done.");

        long begin = System.nanoTime();
        for (String value: testValues) {
            boolean valid = validator.isValid(value);
        }
        long end = System.nanoTime();

        var duration = Duration.of(end - begin, ChronoUnit.NANOS);
        System.out.println("Took " + duration);
    }

    private static List<String> generateTestValues() {
        DataGenerator dataGenerator = new DataGenerator();
        int iterations = 7000;
        int length = 20000;
        return IntStream.range(0, iterations)
                .mapToObj(x -> dataGenerator.createValidBrackets(length, 0.75))
                .toList();
    }

}
