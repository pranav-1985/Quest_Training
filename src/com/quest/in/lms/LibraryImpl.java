package com.quest.in.lms;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibraryImpl implements Library {

    List<Book> availableBooks = new ArrayList<Book>();

    List<BorrowRecord> borrowRecords = new ArrayList<>();


    @Override
    public boolean addBook(Book book) {
        if (book.isBookValid()) {
            availableBooks.add(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean borrowBook(String bookId, Student requestedBy) {
        for (Book book : availableBooks) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    BorrowRecord borrowRecord = new BorrowRecord(book, LocalDateTime.now(), null, requestedBy);
                    borrowRecords.add(borrowRecord);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean returnBook(String bookId, Student student) {

        boolean isBookReturnedSuccessfully = false;
        for (Book book : availableBooks) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                book.setAvailable(true);
                isBookReturnedSuccessfully = true;

            }
        }
        if (isBookReturnedSuccessfully) {
            for (BorrowRecord borrowRecord1 : borrowRecords) {
                if (borrowRecord1.getBook().getBookId().equalsIgnoreCase(bookId)) {
                    borrowRecord1.getBook().setAvailable(true);
                    borrowRecord1.setReturnedAt(LocalDateTime.now());
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public List<Book> availableBooks() {
        return List.of();
    }

    @Override
    public List<BorrowRecord> borrowedHistory() {
        return List.of();
    }
}
