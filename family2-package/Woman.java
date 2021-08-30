package com.family2;

import java.util.Random;

public class Woman extends Person{
    Woman(String lastName, String firstName, int age) {
        super(lastName, firstName, age);
        System.out.println("Woman " + getLastName()+getFirstName() + " created.");
    }

    public Person giveBirth(String childLastName, String childFirstName, int age) {
        Random sexGenerator = new Random();
        boolean sex = sexGenerator.nextBoolean();
        if (sex) {
            System.out.println("\nnew child is boy.");
            return new Man(childLastName, childFirstName, age);
        } else {
            System.out.println("\nnew child is girl.");
            return new Woman(childLastName, childFirstName, age);
        }
    }
}
