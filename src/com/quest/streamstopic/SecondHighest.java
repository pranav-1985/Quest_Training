package com.quest.streamstopic;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondHighest {
    public static void main(String[] args) {


        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);


        List<Integer> numbers = integerStream.collect(Collectors.toList());


        Optional<Integer> maxNum = numbers.stream()
                .max((a, b) -> a > b ? 1 : -1);


        Optional<Integer> secondHighest = numbers.stream()
                .filter(num -> num < maxNum.get())
                .max((a, b) -> a > b ? 1 : -1);

        secondHighest.ifPresent(second -> System.out.println("Second Highest: " + secondHighest.get()));


        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);


        Optional<Integer> secondMax = stream2
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();


        if (secondHighest.isPresent()) {
            System.out.println("Second highest element: " + secondMax.get());
        } else {
            System.out.println("No second highest element found.");
        }


        int a = 1233445;
        String s = String.valueOf(a);
        System.out.println(s);


    }
}
