package com.family;

import com.family.Man;
import com.family.Person;
import com.family.Woman;

import java.util.ArrayList;

public class Family {
    private Woman mother;
    private Man father;
    private ArrayList<Person> children;
    private ArrayList<Pet> pets;

    private Family(Man father, Woman mother) {
        this.father = father;
        this.mother = mother;
        father.setSpouse(mother);
        mother.setSpouse(father);
        children = new ArrayList<Person>();
        pets = new ArrayList<Pet>();
    }

    public static Family getMarried(Man father, Woman mother) {
        System.out.println("\n" + father.getName() + " marry " + mother.getName());
        System.out.println("House " + father.getLastName() + " created.");
        return new Family(father, mother);
    }

    Person addChild(Person child) {
        children.add(child);
        father.addChild(child);
        mother.addChild(child);
        child.setParents(father, mother);
        System.out.println("child " + child.getName() + " added to House " + father.getLastName());
        return child;
    }

    Pet addPet(Pet pet) {
        pets.add(pet);
        return pet;
    }
}
