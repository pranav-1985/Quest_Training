package com.quest.in.lms;

public class Book implements Cloneable {
    private String bookId;
    private String author;
    private String title;
    private boolean isAvailable;

    public Book(String bookId, String author, String title, boolean isAvailable) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isBookValid() {
        if (this.getBookId() != null && this.getTitle() != null && this.isAvailable()) {
            return true;
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book cloneBook = (Book) super.clone();
        cloneBook.setBookId(new String(this.bookId));
        cloneBook.setAuthor(new String(this.author));
        cloneBook.setTitle(new String(this.title));
        cloneBook.setAvailable(this.isAvailable);
        return cloneBook;
    }

    @Override
    public String toString() {
        return "Book : [bookId=" + bookId + ", author=" + author + ", title=" + title;
    }
}
