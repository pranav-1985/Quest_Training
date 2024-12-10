package com.quest.collections_pending;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

    public static void main(String[] args) {

        // Create a Properties object
        Properties properties = new Properties();

        // Set some key-value pairs
        properties.setProperty("database.url", "jdbc:mysql://localhost:3306/mydb");
        properties.setProperty("database.user", "root");
        properties.setProperty("database.password", "password");

        // Save properties to a file
        try ( FileOutputStream out = new FileOutputStream("config.properties")){

            properties.store(out, "Database Configuration");

            System.out.println("Properties saved to config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Load properties from a file
        Properties loadedProperties = new Properties();
        try (FileInputStream in = new FileInputStream("config.properties")) {
            loadedProperties.load(in);

            System.out.println("Properties loaded from config.properties:");
            System.out.println("Database URL: " + loadedProperties.getProperty("database.url"));
            System.out.println("Database User: " + loadedProperties.getProperty("database.user"));
            System.out.println("Database Password: " + loadedProperties.getProperty("database.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
