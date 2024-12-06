package com.quest.newtopics;

import java.io.*;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        Properties props = new Properties();

        props.setProperty("username", "admin");
        props.setProperty("password", "1234");


        try (FileOutputStream fos = new FileOutputStream("config.properties")) {
            props.store(fos, "Application Configurations");
            System.out.println("Properties file saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            System.out.println("Properties file loaded.");
            System.out.println("Username: " + props.getProperty("username"));
            System.out.println("Password: " + props.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

