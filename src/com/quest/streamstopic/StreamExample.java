package com.quest.streamstopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        List<String> nameList = Arrays.asList("nikki", "rahul1", "1ajay", "sheril");

        Stream<String> stream = nameList.stream();

//        long count = stream.count();
//        System.out.println("total count : " + count);

//        Predicate<String> predicate = (s1) -> Character.isAlphabetic(s1.charAt(0));

        List<String> filteredList = stream
                .filter(s1 -> Character.isAlphabetic(s1.charAt(0)))
                .filter(s1 -> Character.isAlphabetic(s1.charAt(s1.length() - 1)))
                .toList();

        System.out.println("filtered list : " + filteredList);

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> integers = stream2.max((i1, i2) -> i1 > i2 ? 1 : -1).stream().toList();
        System.out.println(integers);


    }
}
