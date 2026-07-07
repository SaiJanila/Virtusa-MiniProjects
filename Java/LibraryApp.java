import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        while (true) {

            System.out.println("\n========== Library Management ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Display Members");
            System.out.println("9. Display Borrow Records");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Book Code: ");
                    int code = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Rack Number: ");
                    String rack = sc.nextLine();

                    LibraryBook book = new LibraryBook(code, title, author, category, rack);
                    manager.addBook(book);
                    break;

                case 2:

                    System.out.print("Enter Member ID: ");
                    int memberId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Member Name: ");
                    String memberName = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();

                    Member member = new Member(memberId, memberName, department, contact);
                    manager.registerMember(member);
                    break;

                case 3:

                    System.out.print("Enter Book Title: ");
                    String searchTitle = sc.nextLine();
                    manager.searchBook(searchTitle);
                    break;

                case 4:

                    manager.displayBooks();
                    break;

                case 5:

                    System.out.print("Enter Book Code: ");
                    int borrowBook = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Member ID: ");
                    int borrowMember = Integer.parseInt(sc.nextLine());

                    manager.borrowBook(borrowBook, borrowMember);
                    break;

                case 6:

                    System.out.print("Enter Book Code: ");
                    int returnBook = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Member ID: ");
                    int returnMember = Integer.parseInt(sc.nextLine());

                    manager.submitBook(returnBook, returnMember);
                    break;

                case 7:

                    System.out.print("Enter Book Code to Remove: ");
                    int removeCode = Integer.parseInt(sc.nextLine());

                    manager.removeBook(removeCode);
                    break;

                case 8:

                    manager.displayMembers();
                    break;

                case 9:

                    manager.displayBorrowRecords();
                    break;

                case 10:

                    System.out.println("Thank you for using the Library Management System.");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}