package com.example.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCollectionExample {

    public static void main(String[] args) {

        // Immutable Lists
        List.of();
        List.of(1, 2);
        List.of(args);
        List.copyOf(Arrays.asList(args));
        Arrays.asList(1,2,3,4);

        // Mutable List
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        System.out.println(list1);


        // List Collection Operation
        list1.add(1);
        list1.add(1, 2);
        list1.addAll(List.of(1,2,3,5));
        list1.set(2, 10);

        list1.get(0);
        list1.retainAll(List.of(1,2,3));

        list1.isEmpty();
        list1.size();
        list1.contains(1);
        list1.containsAll(List.of(1,2));
        list1.clear();

        list1.forEach(System.out::println);

        list1.sort(Integer::compareTo);

        list1.remove(0);
        list1.remove(0);
        list1.remove(1);
        list1.removeIf(e -> e == 1);
        list1.removeAll(List.of(1,2));

        list1.toArray();
        list1.listIterator();
        list1.subList(0, 1);
        list1.listIterator(1);
        list1.spliterator();
    }

}
