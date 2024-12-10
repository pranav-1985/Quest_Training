# Serialization in Java

### Definition:
Serialization in Java is the process of converting an object into a byte stream. This byte stream can then be easily saved to a file, sent over a network, or stored in memory. The main goal of serialization is to persist the state of an object, allowing it to be restored later. Deserialization is the reverse process, where the byte stream is converted back into an object.

### Why Serialization?
Serialization is commonly used in scenarios such as:
- Saving the state of an object to a file or database.
- Sending objects over the network.
- Caching objects for faster access.
- Remote method invocation (RMI) for distributed systems.

---

## How Serialization Works
For an object to be serializable in Java, the class of the object must implement the `Serializable` interface. This interface is a marker interface, meaning it does not contain any methods. It simply signals to the Java runtime that the object can be serialized.

### Steps to Serialize an Object:
1. **Implement the `Serializable` interface**: Ensure the class implements `java.io.Serializable`.
2. **Create an `ObjectOutputStream`**: Use this stream to write the object to a file or other output stream.
3. **Write the object using `writeObject()`**: Serialize the object to the output stream.

### Example: Serialization

```java
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("John", 25);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(person); // Serialize the object
            System.out.println("Object serialized!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
