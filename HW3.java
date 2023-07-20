/*
    Richard Phillips & Prisha Patel 
    HW3 ---- July 5th, 2023
*/

import java.util.*;

public class HW3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        String[] bookDetails ;

        System.out.println("Welcome to the book program!");

        while (true) {

            System.out.print("Would you like to create a Book Object? (Yes/No): ");
            String createBook = scanner.nextLine().trim().toLowerCase();

            if (createBook.equals("no")) {
                break;
            }

            if (!createBook.equals("yes")) {
                System.out.println("Oops! That's not a valid entry. Please try again.");
                continue;
            }

            System.out.print("Enter the Author, Title, and the ISBN of the book separated by '/': ");
            bookDetails = scanner.nextLine().trim().split("/");

            String author = bookDetails[0];
            String title = bookDetails[1];
            String isbn = bookDetails[2];

                System.out.print(
                        "Now, tell me if it is a Bookstore Book or a Library Book (enter 'BB' for bookstore book or 'LB' for library book): ");
                String bookType = scanner.nextLine().trim().toUpperCase();

                while (!(bookType.equals("BB") || (bookType.equals("LB") ))) {
                    System.out.println("Oops! That's not a valid entry. Please try again.");
                    bookType = scanner.nextLine().trim().toUpperCase();
                }

                // IF CHOICE IS BOOKSTORE BOOK
                if (bookType.equals("BB")) {
                    System.out.print("Enter the list price of " + title + " by " + author + ": ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Is it on Sale? (Yes/No): ");
                    String onSaleInput = scanner.nextLine().trim().toLowerCase();
                    boolean onSale = onSaleInput.equals("yes");

                    double saleRate = 0.0;
                    if (onSale) {
                        System.out.print("Deduction percentage: ");
                        int deductionPercentage = scanner.nextInt();
                        saleRate = deductionPercentage / 100.0;
                        scanner.nextLine();
                    }

                    BookstoreBook bookstorebook = new BookstoreBook(author, title, isbn, price, onSale, saleRate);
                    books.add(bookstorebook);
                    System.out.println("Here is your Bookstore Book Information");
                    System.out.println(bookstorebook.toString());
                }

                // IF CHOICE IS LIBRARY BOOK
                else if (bookType.equals("LB")) {
                    System.out.print("What's the Subject: ");
                    String subject = scanner.nextLine().trim().toLowerCase();
                    {
                        if (subject.equals("general")) {
                            subject = "A";
                        } else if (subject.equals("philosophy")) {
                            subject = "B";
                        } else if (subject.equals("religion")) {
                            subject = "C";
                        } else if (subject.equals("world history")) {
                            subject = "D";
                        } else if (subject.equals("history of the americas")) {
                            subject = "E";
                        } else if (subject.equals("geography")) {
                            subject = "F";
                        } else if (subject.equals("anthropolgy")) {
                            subject = "G";
                        } else if (subject.equals("social science")) {
                            subject = "H";
                        } else if (subject.equals("internet")) {
                            subject = "I";
                        } else if (subject.equals("politcal science")) {
                            subject = "J";
                        } else if (subject.equals("law")) {
                            subject = "K";
                        } else if (subject.equals("education")) {
                            subject = "L";
                        } else if (subject.equals("music")) {
                            subject = "M";
                        } else if (subject.equals("fine arts")) {
                            subject = "N";
                        } else if (subject.equals("lnaguage")) {
                            subject = "P";
                        } else if (subject.equals("science")) {
                            subject = "Q";
                        } else if (subject.equals("medicine")) {
                            subject = "R";
                        } else if (subject.equals("agriculture")) {
                            subject = "S";
                        } else if (subject.equals("technology")) {
                            subject = "T";
                        } else if (subject.equals("military")) {
                            subject = "U";
                        }

                        LibraryBook libraryBook = new LibraryBook(author, title, isbn, subject);
                        books.add(libraryBook);
                        System.out.println("Here is your Library Book Information");
                        System.out.println(libraryBook.toString());
                }
        }
    }
        // WHAT GETS PRINTED IF THE CHOICE TO CREATE BOOK OBJECT IS NO
        System.out.println("\nSure!");
        System.out.println("Here are all the books you entered...\n");

        int libraryBookCount = 0;
        int bookstoreBookCount = 0;

        for (Book book : books) {
            if (book instanceof LibraryBook) {
                libraryBookCount++;
                System.out.println("Library Books (" + libraryBookCount + ")\n--------------");
                System.out.println(book.toString());
            } else if (book instanceof BookstoreBook) {
                bookstoreBookCount++;
                System.out.println("Bookstore Books (" + bookstoreBookCount + ")\n-----------------");
                System.out.println(book.toString());
            }
        }

        System.out.print("\n----------------\nWould you like to search for a book? (Yes/No) ");
        String choice = scanner.nextLine().trim().toUpperCase();
        while (!(choice.equals("YES") || (choice.equals("NO") ))) {
                System.out.println("Oops! That's not a valid entry. Please try again.");
                choice = scanner.nextLine().trim().toUpperCase();
        }
        if (choice.equals("YES")) {
            System.out.print("Search by ISBN, Author, Title? ");
            choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("author")){
                System.out.print("\n\nEnter the first three letters of the Author: ");
                choice = scanner.nextLine().trim().toUpperCase();
                for (Book book : books){
                    if (book.getAuthor().contains(choice)){
                        System.out.println(book.toString());
                    }
                    else if (!(book.getAuthor().contains(choice))) {
                        System.out.println("Oops Nothing Seems to be Found!");
                    }
                }
                
            }
            
            else if (choice.equals("title")) {
                System.out.println("Enter the Title of the book: ");
                choice = scanner.nextLine().trim().toUpperCase();
                for (Book book : books){
                    if (book.getTitle().contains(choice)){
                        System.out.println(book.toString());
                    }
                    else if (!(book.getTitle().contains(choice))) {
                        System.out.println("Oops Nothing Seems to be Found!");
                    }
                }
            }
            
            else if (choice.equals("isbn")) {
                System.out.println("Enter the ISBN");
                choice = scanner.nextLine().trim().toUpperCase();
                for (Book book : books){
                    if (book.getIsbn().contains(choice)){
                        System.out.println(book.toString());
                    }
                    else if (!(book.getIsbn().contains(choice))) {
                        System.out.println("Oops Nothing Seems to be Found!");
                    }
                }
            }

        }
        else if (choice.equals("NO")) {
            System.out.println("\nTake Care!");
        }
        scanner.close();
    }

    // ___________________________________________________________________________________________________________________________________

    public static abstract class Book {
        private String author;
        private String title;
        private String isbn;

        public Book(String author, String title, String isbn) {
            this.author = author.toUpperCase();
            this.title = title.toUpperCase();
            this.isbn = isbn.toUpperCase();
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getIsbn() {
            return isbn;
        }

    
        public abstract String getBookType();

        @Override
        public String toString() {
            return "[" + isbn + "-" + title + " by: " + author;
        }
    }

    // ___________________________________________________________________________________________________________________________________

    public static class BookstoreBook extends Book {
        private double price;
        private boolean onSale;
        private double saleRate;

        public BookstoreBook(String author, String title, String isbn, double price, boolean onSale, double saleRate) {
            super(author, title, isbn);
            this.price = price;
            this.onSale = onSale;
            this.saleRate = saleRate;
        }

        public double getPrice() {
            return price;
        }

        public boolean isOnSale() {
            return onSale;
        }

        public double getSaleRate() {
            return saleRate;
        }

        @Override
        public String getBookType() {
            return "Bookstore Book";
        }

        @Override
        public String toString() {
            if (onSale) {
                double discount = price - (price * saleRate);
                return super.toString() + ", $" + price + " listed for $" + String.format("%.2f", discount) + "]";
            } else {
                return super.toString() + ", $" + price + "]";
            }
        }
    }

    // ___________________________________________________________________________________________________________________________________

    public static class LibraryBook extends Book {
        private String subject;
        private String callNumber;

        public LibraryBook(String author, String title, String isbn, String subject) {
            super(author, title, isbn);
            this.subject = subject;
            this.callNumber = CallNumberRandom();
        }

        private String CallNumberRandom() {
            String subjectCode = subject.toUpperCase();
            int floorNumber = (int) (Math.random() * 15) + 1;
            String authorInitials = getAuthor().substring(0, 3).toUpperCase();
            char lastDigitOfIsbn = getIsbn().charAt(getIsbn().length() - 1);

            return subjectCode + "." + String.format("%02d", floorNumber) + "." + authorInitials + "."
                    + lastDigitOfIsbn;
        }

        public String getSubject() {
            return subject;
        }

        public String getCallNumber() {
            return callNumber;
        }

        @Override
        public String getBookType() {
            return "\nLibrary Book";
        }

        @Override
        public String toString() {
            return super.toString() + "---" + callNumber + "]";
        }
    }
}