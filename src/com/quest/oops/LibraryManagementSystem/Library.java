package com.quest.oops.LibraryManagementSystem;

public class Library extends LibraryOperations {

    private Book[] books;
    private Member[] members;
    private int bookCount;
    private int memberCount;


    public Library() {
        books = new Book[100];
        members = new Member[100];
        bookCount = 0;
        memberCount = 0;
    }


    @Override
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.printf("Book added: %s%n", book.getTitle());
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    @Override
    public void addMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount++] = member;
            System.out.printf("Member added: %s%n", member.getName());
        } else {
            System.out.println("Library member storage is full!");
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
            System.out.println(book);
        }
    }

    @Override
    public void displayAllMembers() {
        if (memberCount == 0) {
            System.out.println("No members registered.");
            return;
        }
        for (int i = 0; i < memberCount; i++) {
            Member member = members[i];
            System.out.println(member);
        }
    }

    @Override
    public Book searchBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean borrowBook(String isbn, Member member, String borrowDate) {

        String[][] borrowedBooks = member.getBorrowedBooks();
        int borrowedCount = member.getBorrowedCount();


        int borrowLimit = member.getBorrowLimit();

        if (borrowedCount >= borrowLimit) {
            System.out.println("You have reached your borrowing limit.");
            return false;
        }


        Book book = searchBook(isbn);

        if (book == null || !book.checkAvailable()) {
            System.out.println("Book is unavailable or does not exist.");
            return false;
        }


        borrowedBooks[borrowedCount][0] = isbn;
        borrowedBooks[borrowedCount][1] = borrowDate;
        member.setBorrowedCount(borrowedCount + 1);


        book.setAvailable(false);

        System.out.println("Book borrowed successfully.");
        return true;
    }


    @Override
    public boolean returnBook(String isbn, Member member, int returnDate) {

        Book book = searchBook(isbn);

        if (book.getIsbn().isEmpty() || book.checkAvailable()) {
            System.out.println("Book was not borrowed or does not exist.");
            return false;
        }


        String[][] borrowedBooks = member.getBorrowedBooks();
        int borrowDate = -1;
        int index = -1;

        for (int i = 0; i < member.getBorrowedCount(); i++) {
            if (borrowedBooks[i][0].equals(isbn)) {
                borrowDate = Integer.parseInt(borrowedBooks[i][1]);
                index = i;
                break;
            }
        }

        if (borrowDate == -1) {
            System.out.println("Book not found in borrowed list.");
            return false;
        }

        int dateLimit = member.getDayLimit();

        int lateDays = returnDate - borrowDate;
        int fine = calculateFines(member, lateDays, dateLimit);

        if (lateDays > 0) {
            System.out.println("Late return. Fine: " + fine);
        }

        book.setAvailable(true);
        borrowedBooks[index][0] = "";
        borrowedBooks[index][1] = "";
        member.setBorrowedCount(member.getBorrowedCount() - 1);

        System.out.println("Book returned successfully.");
        return true;
    }


    @Override
    public int calculateFines(Member member, int lateDays, int dateLimit) {
        if (lateDays <= 0) {
            return 0;
        }

        if (lateDays > dateLimit) {
            int finePerDay = member.getLATE_FINE();
            return finePerDay * lateDays;
        }
        return 0;
    }


    public Member[] getMembers() {
        return members;
    }

    public int getMemberCount() {
        return memberCount;
    }


}
