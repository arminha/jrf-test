package erni.example.jfr.brackets;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PerformanceTest {

    @Test
    void validateLongStringWithDeeplyNestedBrackets() {
        String value = new DataGenerator().createValidBrackets(200000, 0.75);
        BracketValidator validator = new BracketValidator();

        long begin = System.nanoTime();
        boolean valid = validator.isValid(value);
        long end = System.nanoTime();

        var duration = Duration.of(end - begin, ChronoUnit.NANOS);
        System.out.println("Took " + duration);
        assertTrue(valid);
    }

}
