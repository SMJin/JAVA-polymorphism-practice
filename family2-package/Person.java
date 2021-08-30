package com.family2;

public abstract class Person {
    private final String lastName;
    private final String firstName;
    private final int age;

    Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    String getName() {
        return getLastName()+getFirstName();
    }

    String getLastName() {
        return this.lastName;
    }

    String getFirstName() {
        return this.firstName;
    }

    int getAge() {
        return age;
    }
}
