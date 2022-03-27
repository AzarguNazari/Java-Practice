package com.example.collection.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample {

    private static Consumer printLog = System.out::println;

    public static void main(String[] args) {

        Stream.of(1,2,3,4);
        Stream.builder().add(1).add(2).build();
        Stream.concat(Stream.of(1,2), Stream.of(3,4)).forEach(printLog);
        Stream.empty();
        Stream.generate(() -> List.of(1,2,3,4));

        System.out.println("-------- Using on uninary operator");
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(printLog);

        System.out.println("------ Using the predicate and uninary operator");
        Stream.iterate(1, n -> n < 20 , n -> n * 2)
                .forEach(printLog);
    }

}
