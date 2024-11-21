package com.quest.oops.LibraryManagementSystem;

public abstract class LibraryOperations {

    public abstract void addBook(Book book);

    public abstract void addMember(Member member);

    public abstract void displayAllBooks();

    public abstract void displayAllMembers();

    public abstract Book searchBook(String isbn);

    public abstract boolean borrowBook(String isbn, Member member, String borrowDate);

    public abstract boolean returnBook(String isbn, Member member, int returnDate);

    public abstract int calculateFines(Member member, int lateDays, int dateLimit);
}
