package io.github.java11.interfaces;

public interface Example {

    private static void sayHello() {
        System.out.println("hello world！");
    }

    void normalInterfaceMethod();

    default void interfaceMethodWithDefault() {
        init();
    }

    default void anotherDefaultMethod() {
        init();
    }

    private void init() {
        System.out.println("hello something...");
    }

}
