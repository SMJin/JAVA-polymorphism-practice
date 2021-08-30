package com.family;

import java.util.Random;

public class Woman extends Person {
    Person husband = super.spouse;
    Woman(String name, int age) {
        super(name, age);
        System.out.println("Woman " + name + " created.");
    }

    public Person giveBirth(String firstName, int age) {
        Random sexGenerator = new Random();
        boolean sex = sexGenerator.nextBoolean();
        String childLastName = ((Man)husband).getLastName();
        if (sex) {
            System.out.println("\nnew child is boy.");
            return new Man(childLastName, firstName, age);
        } else {
            System.out.println("\nnew child is girl.");
            return new Woman(childLastName+firstName, age);
        }
    }

    @Override
    public Person setSpouse(Person p) {
        husband = super.setSpouse(p);
        return husband;
    }

    @Override
    public void getRelationshipWith(Person p) {
        if (p == husband) {
            System.out.println(p.getName() + " is " + this.getName() + "'s husband.");
        } else if (p.mother == this) {
            if (p.getClass() == this.getClass()) {
                System.out.println(p.getName() + " is " + this.getName() + "'s daughter.");
            } else {
                System.out.println(p.getName() + " is " + this.getName() + "'s son.");
            }
        } else {
            super.getRelationshipWith(p);
        }
    }
}
