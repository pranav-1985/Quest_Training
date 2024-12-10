# Java Collections Framework Hierarchy

## Overview
The Java Collections Framework provides a unified architecture for representing and manipulating collections. It includes interfaces, classes, and algorithms to work with data structures like lists, sets, queues, and maps.

## Hierarchy

### **Interfaces**
```plaintext
java.util.Collection (Root interface for all collection classes)
  |
  |-- List (Ordered collection, allows duplicates)
  |     |
  |     |-- ArrayList
  |     |-- LinkedList
  |     |-- Vector
  |           |
  |           |-- Stack
  |
  |-- Set (Unordered collection, no duplicates)
  |     |
  |     |-- HashSet
  |     |-- LinkedHashSet
  |     |-- SortedSet (Extends Set, maintains order)
  |           |
  |           |-- TreeSet
  |
  |-- Queue (FIFO data structure)
        |
        |-- PriorityQueue
        |-- Deque (Double-ended queue)
              |
              |-- ArrayDeque
```

### **Map Interface (Separate hierarchy)**
```plaintext
java.util.Map (Key-value pairs)
  |
  |-- HashMap
  |-- LinkedHashMap
  |-- SortedMap (Extends Map, maintains order)
        |
        |-- TreeMap
  |-- WeakHashMap
  |-- IdentityHashMap
  |-- Hashtable (Legacy class)
        |
        |-- Properties
```

## Key Points
1. **List**: Ordered collection, can contain duplicate elements.
2. **Set**: Unordered collection, does not allow duplicates.
3. **Queue**: Designed for holding elements before processing, follows FIFO.
4. **Map**: Stores key-value pairs, keys are unique.

### Legacy Classes (from pre-Java 2):
- Vector
- Stack
- Hashtable
- Properties

## Example Usage
```java
import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        // List Example
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        System.out.println("List: " + list);

        // Set Example
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println("Set: " + set);

        // Map Example
        Map<String, Integer> map = new HashMap<>();
        map.put("Key1", 100);
        map.put("Key2", 200);
        System.out.println("Map: " + map);
    }
}
