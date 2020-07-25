package com.examples.java11.files;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Example {

    public static void main(String[] args) throws Exception {
        String text = "Hello biezhi.";

        Files.writeString(Paths.get("hello.txt"), text);

        String readText = Files.readString(Paths.get("hello.txt"));
        System.out.println(text.equals(readText));

        Files.delete(Paths.get("hello.txt"));
    }

}