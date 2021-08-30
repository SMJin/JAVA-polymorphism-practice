package com.family;

import java.util.ArrayList;

public abstract class Person {
    private final String name;
    private final int age;
    // 가족 집단이 있는데 인간 자체에게도 관계에 대한 것이 필요한가?
    protected Man father;
    protected Woman mother;
    protected Person spouse;    // 배우자
    private ArrayList<Person> children;
    private Pet pet;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.father = null;
        this.mother = null;
        this.spouse = null;
        this.children = new ArrayList<Person>();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setParents(Man father, Woman mother) {
        this.father = father;
        this.mother = mother;
    }

    public Person getFather() {
        if (father == null) {
            System.out.println(this.getName() + " don't know father");
            return null;
        }
        return father;
    }

    public Person getMother() {
        if (mother == null) {
            System.out.println(this.getName() + " don't know mother");
            return null;
        }
        return mother;
    }

    protected Person setSpouse(Person p) {
        this.spouse = p;
        return p;
    }

    public Person getSpouse() {
        if (this.spouse == null) {
            System.out.println(this.getName() + " not married !");
            return null;
        }
        System.out.println(this.getName() + "'s spouse is " + this.spouse.getName());
        return this.spouse;
    }

    public void addChild(Person p) {
        children.add(p);
    }

    public ArrayList<Person> getChildren() {
        if (children.isEmpty()) {
            System.out.println(this.getName() + " don't have child.");
            return null;
        }
        return children;
    }

    public Pet setPet(Pet pet) {
        this.pet = pet;
        return this.getPet();
    }

    public Pet getPet() {
        if (this.pet == null) {
            System.out.println(this.getName() + " have not pet !");
            return null;
        }
        System.out.println(getName() + "'s Pet : \"" + pet.getHowling() + "\"");
        return this.pet;
    }

    public void getRelationshipWith(Person p){
        if (p == father) {
            System.out.println(p.getName() + " is " + this.getName() + "'s father");
        } else if (p == mother) {
            System.out.println(p.getName() + " is " + this.getName() + "'s mother");
        } else {
            System.out.println(this.getName()+ " says : " +p.getName() + ", WHO ARE YOU ?!");
        }
    }
}
