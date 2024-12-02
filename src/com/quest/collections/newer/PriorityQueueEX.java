package com.quest.collections.newer;

import java.util.PriorityQueue;

public class PriorityQueueEX {
    public static void main(String[] args) {


        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        intQueue.add(20);
        intQueue.add(10);
        intQueue.add(30);
        intQueue.add(5);

        System.out.println("Integer PriorityQueue:");
        System.out.println("Peek: " + intQueue.peek());
        System.out.println("Poll: " + intQueue.poll());


        PriorityQueue<Double> doubleQueue = new PriorityQueue<>();
        doubleQueue.add(2.5);
        doubleQueue.add(1.1);
        doubleQueue.add(3.3);
        doubleQueue.add(0.9);

        System.out.println("\nDouble PriorityQueue:");
        System.out.println("Peek: " + doubleQueue.peek());
        System.out.println("Poll: " + doubleQueue.poll());
        System.out.println("Queue after poll: " + doubleQueue);


        PriorityQueue<Character> charQueue = new PriorityQueue<>();
        charQueue.add('z');
        charQueue.add('a');
        charQueue.add('m');
        charQueue.add('b');

        System.out.println("\nCharacter PriorityQueue:");
        System.out.println("Peek: " + charQueue.peek());
        System.out.println("Poll: " + charQueue.poll());


        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("apple");
        stringQueue.add("orange");
        stringQueue.add("banana");
        stringQueue.add("kiwi");

        System.out.println("\nString PriorityQueue:");
        System.out.println("Peek: " + stringQueue.peek());
        System.out.println("Poll: " + stringQueue.poll());


    }
}
