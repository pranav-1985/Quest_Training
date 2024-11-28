package com.quest.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDate {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = dateTime.format(formatter);

        System.out.println(formattedDate);


        LocalDateTime dateTime1 = LocalDateTime.of(2023, 12, 12, 13, 12, 45, 1234);

        System.out.println(dateTime1);

        boolean after = dateTime1.isAfter(dateTime);
        boolean before = dateTime1.isBefore(dateTime);
        System.out.println(after);
        System.out.println(before);

        LocalDateTime plus = dateTime.plus(12, ChronoUnit.DAYS);
        System.out.println(plus);

    }
}
