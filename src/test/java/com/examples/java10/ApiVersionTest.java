package com.examples.java10;

import org.junit.jupiter.api.Test;

public class ApiVersionTest {

    @Test
    public void TestApiVersion(){
        Runtime.Version version = Runtime.version();
        // these were all deprecated in Java 10
        System.out.println(version.major() + "." + version.minor() + "." + version.security());
        // use these instead
        System.out.println(version.feature() + "." + version.interim() + "." + version.update() + "." + version.patch());
    }
}
