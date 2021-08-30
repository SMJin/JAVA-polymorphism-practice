package com.family2;

public class Man extends Person{
    Man(String lastName, String firstName, int age) {
        super(lastName, firstName, age);
        System.out.println("Man " + getLastName()+getFirstName() + " created.");
    }
}
