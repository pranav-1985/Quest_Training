package com.quest.in.lms;

import java.time.LocalDateTime;

public class BorrowRecord {
    private Book book;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;
    private Student requestedBy;


    public BorrowRecord(Book book, LocalDateTime borrowedAt, LocalDateTime returnedAt, Student requestedBy) {
        this.book = book;
        this.borrowedAt = borrowedAt;
        this.returnedAt = returnedAt;
        this.requestedBy = requestedBy;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(LocalDateTime borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }

    public Student getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Student requestedBy) {
        this.requestedBy = requestedBy;
    }
}
