package demo.java;

import static demo.java.Functions.println;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class NoCoroutines {
    public static void main(String[] args) throws InterruptedException {
        WeatherService weatherService = new WeatherService();

        ExecutorService executor = new ForkJoinPool();
        Arrays.asList("Brussels", "Miami", "Moscow", "London")
            .forEach(l ->
                executor.execute(() ->
                    printWeather(weatherService, l)));
        Thread.sleep(2000);
    }

    private static void printWeather(WeatherService weatherService, String location) {
        long start = System.currentTimeMillis();
        println("Requesting weather for %s".formatted(location));
        Weather weather;
        try {
            weather = weatherService.weatherFor(location).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long duration = System.currentTimeMillis() - start;
        println("%s: %s (%s ms)".formatted(location, weather, duration));
    }

    private static class WeatherService {
        CompletableFuture<Weather> weatherFor(String location) {
            return CompletableFuture.supplyAsync(() -> {
                sleep(new Random().nextInt(2000));
                if (Objects.equals(location, "Miami")) {
                    return Weather.SUNNY;
                }
                if (Objects.equals(location, "Brussels")) {
                    return Weather.RAIN;
                }
                if (Objects.equals(location, "Moscow")) {
                    return Weather.SNOW;
                }
                return Weather.CLOUDED;
            });
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private enum Weather {
        SUNNY,
        CLOUDED,
        RAIN,
        SNOW
    }
}
