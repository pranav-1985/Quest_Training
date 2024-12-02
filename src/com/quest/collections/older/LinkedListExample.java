package com.quest.collections.older;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {

        LinkedList<Book> books = new LinkedList<>();


        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));


        System.out.println("Books in the list: " + books);
        System.out.println("------------------------------");

        books.addFirst(new Book("Moby", "Herman Melville"));
        System.out.println("After addFirst: " + books);
        System.out.println("------------------------------");


        books.addLast(new Book("Pride and Prejudice", "Jane Austen"));
        System.out.println("After addLast: " + books);
        System.out.println("------------------------------");


        books.remove(new Book("1984", "George Orwell"));
        System.out.println("After remove: " + books);
        System.out.println("------------------------------");


        books.removeFirst();
        System.out.println("After removeFirst: " + books);
        System.out.println("------------------------------");


        books.removeLast();
        System.out.println("After removeLast: " + books);
        System.out.println("------------------------------");


        Book firstBook = books.getFirst();
        System.out.println("First book in the list: " + firstBook);
        System.out.println("------------------------------");


        Book lastBook = books.getLast();
        System.out.println("Last book in the list: " + lastBook);
        System.out.println("------------------------------");


        boolean containsBook = books.contains(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        System.out.println("Contains 'The Great Gatsby'? " + containsBook);
        System.out.println("------------------------------");


        System.out.println("Size of the list: " + books.size());
        System.out.println("------------------------------");


        Book peekFirst = books.peekFirst();
        System.out.println("Peek First: " + peekFirst);
        System.out.println("------------------------------");


        Book peekLast = books.peekLast();
        System.out.println("Peek Last: " + peekLast);
        System.out.println("------------------------------");


        Book polledFirst = books.pollFirst();
        System.out.println("Polled First: " + polledFirst);
        System.out.println("List after pollFirst: " + books);
        System.out.println("------------------------------");


        Book polledLast = books.pollLast();
        System.out.println("Polled Last: " + polledLast);
        System.out.println("List after pollLast: " + books);
        System.out.println("------------------------------");


        System.out.println("Books after iteration:");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("------------------------------");
    }
}

