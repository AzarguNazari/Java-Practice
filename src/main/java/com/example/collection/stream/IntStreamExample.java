package com.example.collection.stream;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class IntStreamExample {

    public static void main(String[] args) {

        IntConsumer logger = System.out::println;

        IntStream.builder().add(1).add(2).build().forEach(logger);
        IntStream.range(0, 5).forEach(logger);
        IntStream.rangeClosed(0,5).forEach(logger);
        IntStream.empty();
        IntStream.generate(() -> (int) Math.random() * 1000);
        IntStream.iterate(0, n -> n + 1).limit(10).forEach(logger);
        IntStream.iterate(0,  n -> n % 2 == 0, n -> n + 1).limit(10).forEach(logger);

    }

}
