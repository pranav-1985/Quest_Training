# Method References in Java

### Definition:
A **Method Reference** is a shorthand notation of a lambda expression to call a method. It uses the `::` operator to reference a method, which is then passed as an argument to a functional interface. It is a more concise and readable way of using lambdas when a lambda expression only calls an existing method.

### Types of Method References:
1. **Static method reference**: Referring to a static method.
2. **Instance method reference (particular object)**: Referring to an instance method of a particular object.
3. **Instance method reference (any object)**: Referring to an instance method of an arbitrary object of a particular type.
4. **Constructor reference**: Referring to a constructor.

### Syntax:
- Static Method: `ClassName::staticMethod`
- Instance Method (particular object): `instance::instanceMethod`
- Instance Method (any object): `ClassName::instanceMethod`
- Constructor Reference: `ClassName::new`

---

## 1. Static Method Reference

### Example:
```java
import java.util.function.Consumer;

public class MethodReferenceExample {
    public static void printMessage(String message) {
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        // Using method reference for static method
        Consumer<String> messageConsumer = MethodReferenceExample::printMessage;
        messageConsumer.accept("Hello, Method Reference!");
    }
}
