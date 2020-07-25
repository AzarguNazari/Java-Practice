package com.examples.java10.varTest;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AdHocFields {

    /*
     * DOWNSIDES
     *
     *  - verbose
     *  - combination of non-trivial language features (anonymous types & type inference)
     *  - falls apart when extracting methods
     *
     * ALTERNATIVES
     *
     *  - Map.Entry
     *  - a library offering tuples
     *  - wait for records / data classes
     */

    @Test
    public void process() {
        User user1 = new User("user1");
        SimpleAddress simpleAddress = new SimpleAddress("Address 1");
        // with var it is possible to directly declare anonymous types
        // and reference their ad-hoc fields later
        var userWithAddress = new Object() {
            User _user = user1;
            Optional<SimpleAddress> _address = Optional.ofNullable(simpleAddress);
        };

        assertThat(userWithAddress).hasFieldOrProperty("_user").hasFieldOrProperty("_address");
        // further work with `userwithAddress`
        String asString = userWithAddress._user + " at " + userWithAddress._address;
        System.out.println(asString);
    }

    private static void processWithEntries(List<User> users, Map<User, SimpleAddress> addresses) {
        // with `Entry` it is no longer necessary to rely on `var` - it is also shorter
        Optional<Map.Entry<User, FullAddress>> userWithAddress = users.stream()
                .map(user -> Map.entry(user, Optional.ofNullable(addresses.get(user))))
                .filter(o -> o.getValue().isPresent())
                .filter(o -> isValid(o.getValue().get()))
                .map(ua -> Map.entry(ua.getKey(), canonicalize(ua.getValue().get())))
                .findAny();

        // further work with `userwithAddress`
        String asString = userWithAddress
                .map(ua -> ua.getKey() + " at " + ua.getValue())
                .orElse("NONE");
        System.out.println(asString);
    }

    @Test
    public void processWithAnonymousType() {
        // the stream pipeline works exactly the same in Java 8, but `userWithAddress`
        // would have to be `Optional<? extends Object>`, thus loosing the ad-hoc fields
        List<User> users = List.of(new User("user1"), new User("user2"), new User("user3"));
        SimpleAddress simpleAddress = new SimpleAddress("Address 1");
        var userWithAddress = users.stream()
                .map(user -> new Object() {
                    User _user = user;
                    Optional<SimpleAddress> _address = Optional.ofNullable(simpleAddress);
                })
                .filter(o -> o._address.isPresent())
                .filter(o -> isValid(o._address.get()))
                .map(ua -> new Object() {
                    User _user = ua._user;
                    FullAddress _address = canonicalize(ua._address.get());
                })
                .findAny();

        // further work with `userwithAddress`
        String asString = userWithAddress
                .map(ua -> ua._user + " at " + ua._address)
                .orElse("NONE");

        assertThat(asString).isNotEmpty();
        System.out.println(asString);
    }

    private static boolean isValid(SimpleAddress address) {
        // fancy validation of `address`
        return true;
    }

    private static FullAddress canonicalize(SimpleAddress address) {
        // fancy processing of `address`
        return new FullAddress(address.address);
    }

    private static class User {

        private final String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString(){
            return "Name : " + name;
        }
    }

    private static class SimpleAddress {

        private final String address;

        public SimpleAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString(){
            return "Address: " + address;
        }
    }

    private static class FullAddress {

        private final String address;

        public FullAddress(String address) {
            this.address = address;
        }

        public String toString(){
            return "Full Address : " + address;
        }
    }
}
