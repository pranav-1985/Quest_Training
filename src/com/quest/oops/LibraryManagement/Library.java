package com.quest.oops.LibraryManagement;

public class Library extends LibraryOperations {

    private Book[] books;
    private LibraryMember[] members;
    private int bookCount;
    private int memberCount;


    public Library() {
        books = new Book[100];
        members = new LibraryMember[100];
        bookCount = 0;
        memberCount = 0;
    }


    @Override
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }


    @Override
    public void displayAllBooks() {
        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            System.out.println("ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }


    @Override
    public Book searchBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.getIsbn().equals(isbn)) {
                return book;  // Book found, return it
            }
        }
        return null;  // Book not found
    }


    @Override
    public void displayAllMembers() {
        if (memberCount == 0) {
            System.out.println("No members registered.");
            return;
        }
        for (int i = 0; i < memberCount; i++) {
            LibraryMember member = members[i];
            System.out.println("Member ID: " + member.getMemberId() + ", Name: " + member.getName());
        }
    }

    // Implement borrowBook from LibraryOperations
    @Override
    public boolean borrowBook(String isbn, LibraryMember member) {
        Book book = searchBook(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            member.borrowBook(isbn);
            System.out.println("Book borrowed successfully.");
            return true;
        } else {
            System.out.println("Book is unavailable or does not exist.");
            return false;
        }
    }


    @Override
    public boolean returnBook(String isbn, LibraryMember member) {
        Book book = searchBook(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);  // Mark book as available
            member.returnBook(isbn);  // Remove book from member's borrowed list
            System.out.println("Book returned successfully.");
            return true;
        } else {
            System.out.println("Book was not borrowed or does not exist.");
            return false;
        }
    }

    public void addMember(LibraryMember member) {
        if (memberCount < members.length) {
            members[memberCount++] = member;
        } else {
            System.out.println("Library member storage is full!");
        }
    }


    public LibraryMember[] getMembers() {
        return members;
    }
    
    public int getMemberCount() {
        return memberCount;
    }
}
