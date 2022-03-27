package com.example.oops.record;

public class RecordExample {

    public static void main(String[] args) {

        var ahmad = new Person("Ahmad", "Karimi");
        var ahmad2 = new Person("Ahmad", "Karimi");

        // record contains by default the equal, hashcode, and getters methods
        System.out.println(ahmad.equals(ahmad2));

        ahmad.work();
    }



}

record Person(String fname, String lname) implements Responsibilities {

    public Person(String fname){
        this(fname, null);
    }

    @Override
    public void work() {
        System.out.println("Working...");
    }
}

interface Responsibilities {
    void work();
}