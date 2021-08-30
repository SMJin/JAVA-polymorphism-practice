package com.family2;

public class Dog implements Pet {
    Person master;
    Dog(Person master) {
        this.master = master;
    }
    public String getHowling() {
        return "멍멍";
    }
    public String getType() { return "Dog"; };
    public Person getMaster() { return master; }
}
