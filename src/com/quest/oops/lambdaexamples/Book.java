package com.quest.oops.lambdaexamples;

public class Book {

    private String title;
    private String author;
    private int price;
    private int stock;

    private final double DISCOUNT_PERCENTAGE = 10;

    public Book(String title, String author, int price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDiscountPercentage() {
        return DISCOUNT_PERCENTAGE;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Stock: " + getStock();
    }
}

