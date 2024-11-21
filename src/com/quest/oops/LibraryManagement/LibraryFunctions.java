package com.quest.oops.LibraryManagement;

public abstract class LibraryFunctions {

    public abstract void addBook(Book book);

    public abstract void displayAllBooks();

    public abstract Book searchBook(String isbn);

    public abstract void displayAllMembers();

    public abstract boolean borrowBook(String isbn, LibraryMember member);

    public abstract boolean returnBook(String isbn, LibraryMember member);
}
