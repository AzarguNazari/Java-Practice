package com.example.collection;

import java.util.Arrays;
import java.util.List;

public class ListCollectionExample {

    public static void main(String[] args) {

        List.of();
        List.of(1, 2);
        List.of(args);
        List.copyOf(Arrays.asList(args));


    }

}
