# Deserialization in Java

### Definition:
Deserialization in Java is the reverse process of serialization. It is the process of reconstructing an object from its serialized byte stream. In other words, it converts a sequence of bytes into an object. This allows the object to be retrieved from storage, memory, or a network connection and be used again in the program.

### Why Deserialization?
Deserialization is typically used in scenarios such as:
- Restoring objects from a file, database, or network.
- Rebuilding object states after they have been serialized and sent across a network or saved to a file.
- Reading cached objects to restore their previous state.

---

## How Deserialization Works
For deserialization to work, the following conditions must be met:
1. The class of the object being deserialized must be available in the classpath (i.e., it must be present in the program).
2. The class must be `Serializable`, meaning it should have implemented the `Serializable` interface before it was serialized.

### Steps to Deserialize an Object:
1. **Create an `ObjectInputStream`**: This stream is used to read the byte stream that represents the serialized object.
2. **Use `readObject()` Method**: This method converts the byte stream back into the original object.

### Example: Deserialization

Consider the scenario where an object is serialized to a file, and then it is deserialized back to restore its original state.

```java
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person person = (Person) in.readObject(); // Deserialize the object
            System.out.println("Object deserialized!");
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person implements java.io.Serializable {
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
