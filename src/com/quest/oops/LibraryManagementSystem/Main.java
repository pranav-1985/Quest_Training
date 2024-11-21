package com.quest.oops.LibraryManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("B123", "The Rumbling", "E. Jaeger", 1925));
        library.addBook(new Book("B456", "The Hammer", "Harper", 1960));

        library.addMember(new PremiumMember("1", "Alice", "alice@example.com", "Premium"));
        library.addMember(new NormalMember("2", "Jobe", "Jobe@example.com", "Normal"));


        while (true) {
            System.out.println("\nLibrary Management System" +
                    "\n1. Borrow Book" +
                    "\n2. Return Book" +
                    "\n3. Search Book" +
                    "\n4. Display all Books" +
                    "\n5. Display all members" +
                    "\n6. Add Book" +
                    "\n7. Add Member" +
                    "\n8. exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String memberId;
            Member member;
            switch (choice) {
                case 1:
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    member = findMember(library, memberId);
                    if (member != null) {
                        System.out.print("Enter ISBN of the book to borrow: ");
                        String isbnToBorrow = scanner.nextLine();
                        System.out.print("Enter Date of Borrow (1-9): ");
                        int dateOfBorrow = scanner.nextInt();
                        scanner.nextLine();
                        String dateOfBorrowStr = Integer.toString(dateOfBorrow);
                        boolean success = library.borrowBook(isbnToBorrow, member, dateOfBorrowStr);
                        if (success) {
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Sorry, the book is either unavailable or doesn't exist.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 2: // Return Book
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    member = findMember(library, memberId);
                    if (member != null) {
                        System.out.print("Enter ISBN of the book to return: ");
                        String isbnToReturn = scanner.nextLine();
                        System.out.print("Enter Return Date (1-9): ");
                        int returnDate = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        boolean successReturn = library.returnBook(isbnToReturn, member, returnDate);
                        if (successReturn) {
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Error in returning the book.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 3: // Search Book
                    System.out.print("Enter ISBN to search: ");
                    String isbnSearch = scanner.nextLine();
                    Book foundBook = library.searchBook(isbnSearch);
                    if (foundBook != null) {
                        System.out.println("Book Found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    library.displayAllBooks();
                    break;

                case 5:
                    library.displayAllMembers();
                    break;

                case 6:
                    System.out.print("Enter ISBN of the book: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author of the book: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year of publication: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(new Book(isbn, title, author, year));
                    System.out.println("Book added successfully.");
                    break;

                case 7: // Add Member
                    System.out.print("Enter Member ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Member Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Membership Type (Premium/Normal): ");
                    String membershipType = scanner.nextLine();
                    if (membershipType.equalsIgnoreCase("Premium")) {
                        library.addMember(new PremiumMember(id, name, email, membershipType));
                    } else if (membershipType.equalsIgnoreCase("Normal")) {
                        library.addMember(new NormalMember(id, name, email, membershipType));
                    } else {
                        System.out.println("Invalid membership type. Member not added.");
                    }
                    System.out.println("Member added successfully.");
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static Member findMember(Library library, String memberId) {
        Member[] members = library.getMembers();
        for (int i = 0; i < library.getMemberCount(); i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;
    }
}
