package com.quest.collections.newer;


import java.util.ArrayList;
import java.util.List;

public class CollectionSort{
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(3, "Alice", 30, "New York"));
        personList.add(new Person(1, "Bob", 25, "Los Angeles"));
        personList.add(new Person(4, "Charlie", 35, "Chicago"));
        personList.add(new Person(2, "Dave", 28, "Houston"));


        for (int i = 0; i < personList.size() - 1; i++) {
            for (int j = i + 1; j < personList.size(); j++) {
                if (personList.get(i).getId() > personList.get(j).getId()) {
                    Person temp = personList.get(i);
                    personList.set(i, personList.get(j));
                    personList.set(j, temp);
                }
            }
        }


        System.out.println("Sorted List by ID:");
        for (Person person : personList) {
            System.out.println(person);
        }
    }

}
