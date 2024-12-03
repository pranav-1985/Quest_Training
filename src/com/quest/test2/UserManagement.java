package com.quest.test2;

import java.util.HashMap;
import java.util.Map;

public class UserManagement {

    private Map<String, User> usersMap;

    public UserManagement() {
        this.usersMap = new HashMap<>();
    }

    public void addUser(User user) {
        if (usersMap.containsKey(user.getUserName())) {
            throw new DuplicateException("User already exists");
        }
        usersMap.put(user.getUserName(), user);
        System.out.println("User " + user.getUserName() + " added.");
    }

    public void removeUser(String userName) {
        if (usersMap.containsKey(userName)) {
            usersMap.remove(userName);
            System.out.println("User " + userName + " removed.");
        } else {
            System.out.println("User " + userName + " not found.");
        }
    }

    public User getUser(String userName) {
        if (usersMap.containsKey(userName)) {
            return usersMap.get(userName);
        } else {
            System.out.println("User " + userName + " not found.");
            return null;
        }
    }

    public void displayUsers() {
        if (usersMap.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("List of users:");
            for (User user : usersMap.values()) {
                System.out.println(user);
            }
        }
    }
    
}
