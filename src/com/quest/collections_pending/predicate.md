# Predicate in Java

### Definition:
A `Predicate` is a functional interface in Java that represents a condition or a boolean-valued function of one argument. It is often used for testing a condition and returning a boolean value based on the input.

### Method:
- `test(T t)`: Evaluates the predicate on the given argument and returns a boolean value (`true` or `false`).

### Use Case:
`Predicate` is commonly used for filtering, validating, or checking if an object satisfies a particular condition.

### Example:
```java
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Predicate that checks if a number is even
        Predicate<Integer> isEven = number -> number % 2 == 0;
        
        System.out.println("Is 4 even? " + isEven.test(4));  // true
        System.out.println("Is 7 even? " + isEven.test(7));  // false
        
        // Predicate that checks if a string has more than 5 characters
        Predicate<String> hasMoreThanFiveChars = str -> str.length() > 5;
        System.out.println("Does 'HelloWorld' have more than 5 characters? " + hasMoreThanFiveChars.test("HelloWorld"));  // true
        System.out.println("Does 'Java' have more than 5 characters? " + hasMoreThanFiveChars.test("Java"));  // false
    }
}
