package com.quest.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraylistPerson {
    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Ron", 21, "Male", "123 Oak St"));
        persons.add(new Person("Sara", 19, "Female", "456 Pine St"));
        persons.add(new Person("John", 25, "Male", "789 Maple St"));
        persons.add(new Person("Anna", 17, "Female", "101 Birch St"));
        persons.add(new Person("Mike", 22, "Male", "202 Elm St"));
        persons.add(new Person("Ella", 18, "Female", "303 Cedar St"));


        for (Person person : persons) {
            if (person.getAge() > 20) {
                System.out.println(person);
            }
        }

        System.out.println("-----------------------");

        Iterator<Person> iterator = persons.iterator();

        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getAge() < 20) {
                System.out.println(person);
            }
        }
    }
}
