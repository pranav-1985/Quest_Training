# Supplier in Java

### Definition:
A `Supplier` is a functional interface in Java that represents a supplier of results. It does not take any input but returns a result.

### Method:
- `get()`: Returns a result. The result is of type `T`, which is the type parameter of the `Supplier`.

### Use Case:
`Supplier` is typically used in scenarios where you need to lazily generate or fetch data, such as when you want to provide a default value or fetch a value on demand.

### Example:
```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Supplier that returns a random greeting
        Supplier<String> greetSupplier = () -> "Hello from Supplier!";
        System.out.println(greetSupplier.get());
        
        // Supplier that generates a random number
        Supplier<Double> randomNumberSupplier = () -> Math.random();
        System.out.println("Random number: " + randomNumberSupplier.get());
    }
}
