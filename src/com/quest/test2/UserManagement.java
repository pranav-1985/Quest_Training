package com.quest.test2;

import java.util.HashMap;
import java.util.Map;

public class UserManagement {

    private Map<String, User> users;

    public UserManagement() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        if (users.containsKey(user.getUserName())) {
            throw new DuplicateException("User already exists");
        }
        users.put(user.getUserName(), user);
        System.out.println("User " + user.getUserName() + " added.");
    }

    public void removeUser(String userName) {
        if (users.containsKey(userName)) {
            users.remove(userName);
            System.out.println("User " + userName + " removed.");
        } else {
            System.out.println("User " + userName + " not found.");
        }
    }

    public User getUser(String userName) {
        if (users.containsKey(userName)) {
            return users.get(userName);
        } else {
            System.out.println("User " + userName + " not found.");
            return null;
        }
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("List of users:");
            for (User user : users.values()) {
                System.out.println(user);
            }
        }
    }
    
}
