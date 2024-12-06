package com.quest.practiceQuestions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class IndianDate {
    public static void main(String[] args) {

        LocalDateTime currentDateTime = LocalDateTime.now();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


        System.out.println("Indian Date Format: " + currentDateTime.format(formatter));
    }

}
