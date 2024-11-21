package com.quest.oops.LibraryManagement;


public class LibraryMember {
    private String memberId;
    private String name;
    private String contactInfo;
    private String[] borrowedBooks;
    private int borrowedCount;

    public LibraryMember(String memberId, String name, String contactInfo) {
        this.memberId = memberId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new String[10];
        this.borrowedCount = 0;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String[] getBorrowedBooks() {
        return borrowedBooks;
    }


    public void borrowBook(String isbn) {
        if (borrowedCount < borrowedBooks.length) {
            borrowedBooks[borrowedCount++] = isbn;
        } else {
            System.out.println("You cannot borrow more than 10 books.");
        }
    }


    public void returnBook(String isbn) {
        boolean bookFound = false;
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] != null && borrowedBooks[i].equals(isbn)) {
                borrowedBooks[i] = null;
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book is not borrowed.");
        }
    }
}
