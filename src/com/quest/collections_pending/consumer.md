# Functional Interfaces in Java: Consumer, Predicate, Supplier

Java 8 introduced several functional interfaces in the `java.util.function` package to support functional programming. Among these, `Consumer`, `Predicate`, and `Supplier` are commonly used.

---

## 1. Consumer
### Definition:
A `Consumer` is a functional interface that accepts a single input and performs some operation on it without returning any result.

### Method:
- `accept(T t)`: Performs the operation on the given argument.

### Use Case:
`Consumer` is useful for operations like printing, logging, or applying some logic to an object.

### Example:
```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        printMessage.accept("Hello, Consumer!");
    }
}


