package io.github.java11.processor;

public class Example {

    public static void main(String[] args) {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("process PID = " + currentProcess.pid());
    }

}
