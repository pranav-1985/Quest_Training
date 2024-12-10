package com.quest.streamstopic;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences {
    public static void main(String[] args) {

        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100) + 1;

        Predicate<Integer> isEven = n -> n % 2 == 0;

        Function<Integer,Integer> function=(n)->{
          if(isEven.test(n)){
              return n*n;
          }
          return n*2;
        };

        Consumer<String> printNum = System.out::println;

        processNumber(
                randomSupplier,
                isEven,
                function,
                printNum
        );
    }


    public static void processNumber(Supplier<Integer> supplier, Predicate<Integer> isEven,
                                     Function<Integer, Integer> function, Consumer<String> consumer) {

        int number = supplier.get();
        System.out.println("Generated Number: " + number);


        Optional<Integer> result = Optional.of(number)
                .filter(isEven)
                .map(function);

        if (result.isPresent()) {
            consumer.accept("Result: " + result.get());
        } else {
            consumer.accept("No result");
        }

    }
}
