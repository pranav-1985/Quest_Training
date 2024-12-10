package com.quest.threads;

import java.util.ArrayList;
import java.util.List;

public class SharedBuffer {

    private List<String> buffer = new ArrayList<>();
    private final int MAX_CAPACITY = 3;


    public synchronized void produce(String item) throws InterruptedException {

        while (buffer.size() == MAX_CAPACITY) {
            wait();
        }
        buffer.add(item);
        System.out.println("Producer produced: " + item);
        notify();
    }


    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        String item = buffer.removeFirst();
        System.out.println("Consumer consumed: " + item);
        notify();
    }
}
