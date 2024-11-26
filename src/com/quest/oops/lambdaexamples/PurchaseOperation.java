package com.quest.oops.lambdaexamples;

public class PurchaseOperation {

    private Book[] books;
    private int index;


    public PurchaseOperation() {
        books = new Book[10];
        index = 0;
    }

    public void addBook(Book book) {
        if (index < books.length) {
            books[index++] = book;
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Book array is full. Cannot add more books.");
        }
    }

    public void buyBook(String name) {

        Book book = findBook(name);
        if (book != null && book.getTitle().equals(name)) {
            if (book.getStock() > 0) {
                book.setStock(book.getStock() - 1);
                System.out.println("Book purchased: " + book.getTitle() + "with cost of " + discountedPrice(book) + " after discount");
            } else {
                throw new OutOfStockException("Out of stock");
            }
        }
        if (book == null) {
            System.out.println("Book not found");
        }
    }

    public void getBooksOver(double price) {

        boolean bookFound = false;
        CheckBookPrice checkPrice = book -> book.getPrice() >= price;

        for (Book book : books) {
            if (book != null && checkPrice.test(book)) {
                System.out.println(book + "\n");
                bookFound = true;
            }
        }

        if (!bookFound) {
            System.out.println("No books found with price >= " + price);
        }
    }

    public double discountedPrice(Book book) {
        double price = book.getPrice();
        double discount = book.getDiscountPercentage();
        return price - (price * discount / 100);
    }

    public void displayAllBooks() {
        for (Book book : books) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

}

@FunctionalInterface
interface CheckBookPrice {
    boolean test(Book book);
}
