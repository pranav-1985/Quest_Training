package com.quest.in.lms;

import java.util.List;

public interface Library {

    boolean addBook(Book book);

    boolean borrowBook(String bookId, Student requestedBy);

    boolean returnBook(String bookId, Student student);

    List<Book> availableBooks();

    List<BorrowRecord> borrowedHistory();

}
