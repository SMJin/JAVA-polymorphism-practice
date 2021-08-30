package com.family;

public class Man extends Person {
    String lastName;
    Person wife = super.spouse;
    Man(String lastName, String firstName, int age) {
        super(lastName+firstName, age);
        this.lastName = lastName;
        System.out.println("Man " + lastName+firstName + " created.");
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public Person setSpouse(Person p) {
        wife = super.setSpouse(p);
        return wife;
    }

    @Override
    public void getRelationshipWith(Person p) {
        if (p == wife) {
            System.out.println(p.getName() + " is " + this.getName() + "'s wife.");
        } else if (p.father == this) {
            if (p.getClass() == this.getClass()) {
                System.out.println(p.getName() + " is " + this.getName() + "'s son.");
            } else {
                System.out.println(p.getName() + " is " + this.getName() + "'s daughter.");
            }
        } else {
            super.getRelationshipWith(p);
        }
    }
}
