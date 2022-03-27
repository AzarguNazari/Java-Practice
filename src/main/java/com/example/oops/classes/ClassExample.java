package com.example.oops.classes;

import java.util.Objects;

public class ClassExample {

    public static void main(String[] args) {

        var teacher1 = new Teacher("Karim", "Amini", "Elementary School Teacher", 20000.0);

        System.out.println(teacher1);
    }

}

abstract class Person {

    protected String fname;
    protected String lname;

    protected Person(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    protected Person(String fname){
        this(fname, null);
    }
}

interface Responsbilities {
    void work();
}

class Teacher extends Person implements Responsbilities {

    private double salary;
    private String title;

    public Teacher(String fname, String lname, String title, double salary){
        super(fname, lname);
        this.salary = salary;
        this.title = title;
    }

    @Override
    public void work() {
        System.out.println("Teaching...");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Double.compare(teacher.salary, salary) == 0 && title.equals(teacher.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, title);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", salary=" + salary +
                ", title='" + title + '\'' +
                '}';
    }
}
