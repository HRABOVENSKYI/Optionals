package org.example;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("James", "JAMES@gmail.com");
        Person person2 = new Person("James", null);

        System.out.println(person1
                .getEmail()
                .map(String::toLowerCase)
                .orElse("Email not provided")); // james@gmail.com

        System.out.println(person2
                .getEmail()
                .map(String::toLowerCase)
                .orElse("Email not provided")); // Email not provided
    }
}
