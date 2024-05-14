package erni.example.jfr.brackets;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {
        BracketValidator validator = new BracketValidator();
        List<String> testValues = generateTestValues();

        System.out.println("Setup done.");

        var duration = runInNewThread(() -> doWork(testValues, validator));

        System.out.println("Took " + duration);
    }

    private static Duration doWork(List<String> testValues, BracketValidator validator) {
        long begin = System.nanoTime();
        for (String value : testValues) {
            boolean valid = validator.isValid(value);
        }
        long end = System.nanoTime();
        return Duration.of(end - begin, ChronoUnit.NANOS);
    }

    private static Duration runInNewThread(Callable<Duration> callable) throws InterruptedException, ExecutionException {
        try (ExecutorService executor = Executors.newFixedThreadPool(1)) {
            var future = executor.submit(callable);
            return future.get();
        }
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
