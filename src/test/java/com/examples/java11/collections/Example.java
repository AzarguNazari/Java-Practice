package com.examples.java11.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;


public class Example {

    public static void main(String[] args) {

        List immutableList = List.of();

        var foo = List.of("hazargul", "github", "anotherone");

        Map emptyImmutableMap = Map.of();

        var mmp = Map.of(2017, "good year", 2018, "another good year");

        Map<Integer, String> emptyEntryMap = Map.ofEntries(
                entry(20, "twenty"),
                entry(30, "thirty"),
                entry(40, "forty")
        );

        Map.Entry<String, String> immutableMapEntry = Map.entry("hazar gul nazari", "emmmm");
        Map.ofEntries(immutableMapEntry);

        Set<String> immutableSet = Set.of();

        Set<String> bar = Set.of("one", "two", "three", "four", "five");

    }

}
