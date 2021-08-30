package com.family2;

import java.util.ArrayList;

public class Family {
    private Woman mother;
    private Man father;
    private ArrayList<Person> children;
    private ArrayList<Pet> pets;

    private Family(Man father, Woman mother) {
        this.father = father;
        this.mother = mother;
        children = new ArrayList<Person>();
        pets = new ArrayList<Pet>();
    }

    public static Family getMarried(Man father, Woman mother) {
        System.out.println("\n" + father.getName() + " marry " + mother.getName());
        System.out.println("House " + father.getLastName() + " created.");
        return new Family(father, mother);
    }

    Person addChild(String childName, int age) {
        Person newChild = mother.giveBirth(father.getLastName(), childName, age);
        children.add(newChild);
        System.out.println("child " + childName + " added to House " + father.getLastName());
        return newChild;
    }

    Pet addPet(Pet pet) {
        pets.add(pet);
        System.out.println(pet.getMaster().getName() + "'s " + pet.getType() + " howling : \"" + pet.getHowling() + "\"");
        return pet;
    }

    boolean isMarried(Man husband, Woman wife) {
        System.out.print("\n" + husband.getName() + " and " + wife.getName());
        if (husband == father && wife == mother) {
            System.out.println(" married.");
            return true;
        }
        System.out.println(" don't know each other.");
        return false;
    }

    void isParentChild(Person parent, Person child) {
        System.out.print("\n" + parent.getName() + " is " + child.getName() + "'s ");
        if (!isParent(parent)) {
            System.out.println("not Parent of this Family... maybe child? or stranger.");
        }

        System.out.print(child.getName() + " is " + parent.getName() + "'s ");
        if (!isChild(child)) {
            System.out.println("not Child of this Family... maybe parent? or stranger.");
        }
    }

    private boolean isChild(Person child) {
        for (Person c : children) {
            if (c == child) {
                if (!isSon(child) && !isDaughter(child)) {
                    System.out.println("just child. not found child's sex.");
                }
                return true;
            }
        }
        return false;
    }

    private boolean isSon(Person son) {
        if (son.getClass() == father.getClass()) {
            System.out.println("son.");
            return true;
        }
        return false;
    }

    private boolean isDaughter(Person daughter) {
        if (daughter.getClass() == mother.getClass()) {
            System.out.println("daughter.");
            return true;
        }
        return false;
    }

    private boolean isParent(Person parent) {
        if (isFather(parent) || isMother(parent)) {
            return true;
        }
        return false;
    }

    private boolean isFather(Person father) {
        if (father == this.father) {
            System.out.println("Father.");
            return true;
        }
        return false;
    }

    private boolean isMother(Person mother) {
        if (mother == this.mother) {
            System.out.println("Mother.");
            return true;
        }
        return false;
    }
}
