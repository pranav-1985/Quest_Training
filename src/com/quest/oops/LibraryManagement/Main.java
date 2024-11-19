package com.quest.oops.LibraryManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("B123", "The Rumbling", "E. Jaeger", 1925));
        library.addBook(new Book("B456", "The Hammer", "Harper", 1960));


        library.addMember(new LibraryMember("1", "Alice", "alice@example.com"));
        library.addMember(new LibraryMember("2", "Jobe", "Jobe@example.com"));


        while (true) {
            System.out.println("\nLibrary Management System" +
                    "\n1. Borrow Book" +
                    "\n2. Return Book" +
                    "\n3. Search Book" +
                    "\n4. Display all Books" +
                    "\n5. Display all members" +
                    "\n6. exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String memberId;
            LibraryMember member;
            switch (choice) {
                case 1:
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    member = findMember(library, memberId);
                    if (member != null) {
                        System.out.print("Enter ISBN of the book to borrow: ");
                        String isbnToBorrow = scanner.nextLine();
                        boolean success = library.borrowBook(isbnToBorrow, member);
                        if (success) {
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Sorry, the book is either unavailable or doesn't exist.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    member = findMember(library, memberId);
                    if (member != null) {
                        System.out.print("Enter ISBN of the book to return: ");
                        String isbnToReturn = scanner.nextLine();
                        boolean successReturn = library.returnBook(isbnToReturn, member);
                        if (successReturn) {
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Error in returning the book.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN to search: ");
                    String isbnSearch = scanner.nextLine();
                    Book foundBook = library.searchBook(isbnSearch);
                    if (foundBook != null) {
                        System.out.println("Book Found: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
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
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static LibraryMember findMember(Library library, String memberId) {
        LibraryMember[] members = library.getMembers();
        for (int i = 0; i < library.getMemberCount(); i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;
    }
}
