import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;
    LocalDate issueDate;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

public class LibrarySystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // add book
    static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            books.add(new Book(id, title, author));
            System.out.println("Book added successfully");

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    // issue book
    static void issueBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Book b : books) {
                if (b.id == id && !b.isIssued) {

                    System.out.print("Enter issue date (YYYY-MM-DD): ");
                    String dateInput = sc.nextLine();
                    b.issueDate = LocalDate.parse(dateInput);

                    b.isIssued = true;
                    System.out.println("Book issued");
                    return;
                }
            }
            System.out.println("Book not available");

        } catch (Exception e) {
            System.out.println("Invalid input format");
        }
    }

    // return book
    static void returnBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Book b : books) {
                if (b.id == id && b.isIssued) {

                    System.out.print("Enter return date (YYYY-MM-DD): ");
                    String returnInput = sc.nextLine();
                    LocalDate returnDate = LocalDate.parse(returnInput);

                    long days = ChronoUnit.DAYS.between(b.issueDate, returnDate);

                    if (days > 7) {
                        long fine = (days - 7) * 10;
                        System.out.println("Late return. Fine: " + fine);
                    } else {
                        System.out.println("Returned on time");
                    }

                    b.isIssued = false;
                    return;
                }
            }
            System.out.println("Invalid return");

        } catch (Exception e) {
            System.out.println("Invalid input format");
        }
    }

    // remove book
    static void removeBook() {
        try {
            System.out.print("Enter Book ID to remove: ");
            int id = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).id == id) {

                    if (books.get(i).isIssued) {
                        System.out.println("Book is issued, cannot remove");
                        return;
                    }

                    books.remove(i);
                    System.out.println("Book removed successfully");
                    return;
                }
            }

            System.out.println("Book not found");

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    // search book
    static void searchBook() {
        System.out.print("Enter title to search: ");
        String t = sc.nextLine();

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(t)) {
                System.out.println("Found: " + b.title + " by " + b.author);
                return;
            }
        }
        System.out.println("Book not found");
    }

    // show all books
    static void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        for (Book b : books) {
            System.out.println(b.id + " - " + b.title + " - " + b.author +
                    (b.isIssued ? " (Issued)" : " (Available)"));
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Search Book");
            System.out.println("6. Show Books");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");

            try {
                int ch = Integer.parseInt(sc.nextLine());

                switch (ch) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        issueBook();
                        break;
                    case 3:
                        returnBook();
                        break;
                    case 4:
                        removeBook();
                        break;
                    case 5:
                        searchBook();
                        break;
                    case 6:
                        showBooks();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Enter valid number");
            }
        }
    }
}
