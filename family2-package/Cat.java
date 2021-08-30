package com.family2;

public class Cat implements Pet {
    Person master;
    Cat(Person master) {
        this.master = master;
    }
    public String getHowling() {
        return "야옹";
    }
    public String getType() { return "Cat"; };
    public Person getMaster() { return master; }
}
