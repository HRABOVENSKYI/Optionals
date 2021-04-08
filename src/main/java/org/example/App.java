package org.example;

import java.util.Optional;

public class App {
    public static void main( String[] args ) {
        // Optional empty Object
        Optional<Object> hello1 = Optional.empty();

        // Optional object of type String
        Optional<String> hello2 = Optional.of("hello");

        // if we don't know whether object has value or is of type null, declare like this
        Optional<String> hello3 = Optional.ofNullable(null);

        System.out.println(hello1.isPresent()); // false
        System.out.println(hello1.isEmpty()); // true

        System.out.println(hello2.isPresent()); // true
        System.out.println(hello2.isEmpty()); // false

        System.out.println(hello3.isPresent()); // false
        System.out.println(hello3.isEmpty()); // true

        // Map makes some changes on value if it is present
        // orElse returns "world" if hello is empty or equals to null
        String orElse2 = hello2
                .map(String::toUpperCase)
                .orElse("world");
        System.out.println(orElse2); // HELLO

        String orElse3 = hello3
                .map(String::toUpperCase)
                .orElse("world");
        System.out.println(orElse3); // world

        // orElseGet with Supplier parameter
        String orElseGet2 = hello2
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // ... any logic
                    return "done";
                });
        System.out.println(orElseGet2); // HELLO

        String orElseGet3 = hello3
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // ... any logic
                    return "done";
                });
        System.out.println(orElseGet3); // done

        // orElseThrow with Supplier parameter
        String orElseThrow2 = hello2
                .map(String::toUpperCase)
                .orElseThrow(IllegalStateException::new);
        System.out.println(orElseThrow2); // HELLO

//        String orElseThrow3 = hello3
//                .map(String::toUpperCase)
//                .orElseThrow(IllegalStateException::new);
//        System.out.println(orElseThrow3); // throws this exception

        // ifPresent
        hello1.ifPresent(System.out::println); //

        hello2.ifPresent(System.out::println); // hello

        hello3.ifPresent(System.out::println); //

        // ifPresentOrElse
        hello1.ifPresentOrElse(System.out::println, () -> {
            System.out.println("yeee");
        }); // yeee

        hello2.ifPresentOrElse(word -> {
            System.out.println(word); // Could do as before, with :: operator
        }, () -> {
            System.out.println("yeee");
        }); // hello

        hello3.ifPresentOrElse(System.out::println, () -> {
            System.out.println("yeee");
        }); // yeee
    }
}
