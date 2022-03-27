package com.example.collection.stream;

import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String[] args) {


        Stream.of(1,2,3,4,5).map(n -> n * 2)
                            .filter(n -> n == 6)
                            .forEach(System.out::println);


    }

}
