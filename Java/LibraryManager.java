import java.util.ArrayList;

public class LibraryManager {

    private ArrayList<LibraryBook> bookList;
    private ArrayList<Member> memberList;
    private ArrayList<BorrowRecord> borrowList;

    public LibraryManager() {
        bookList = new ArrayList<>();
        memberList = new ArrayList<>();
        borrowList = new ArrayList<>();
    }

    // Add a new book
    public void addBook(LibraryBook book) {

        for (LibraryBook b : bookList) {
            if (b.getBookCode() == book.getBookCode()) {
                System.out.println("Book code already exists.");
                return;
            }
        }

        bookList.add(book);
        System.out.println("Book added successfully.");
    }

    // Register member
    public void registerMember(Member member) {

        for (Member m : memberList) {
            if (m.getMemberId() == member.getMemberId()) {
                System.out.println("Member already registered.");
                return;
            }
        }

        memberList.add(member);
        System.out.println("Member registered successfully.");
    }

    // Search by title
    public void searchBook(String title) {

        boolean found = false;

        for (LibraryBook b : bookList) {

            if (b.getBookTitle().equalsIgnoreCase(title)) {
                System.out.println("\nBook Found");
                System.out.println(b);
                found = true;
            }

        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Display all books
    public void displayBooks() {

        if (bookList.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        for (LibraryBook b : bookList) {
            System.out.println("--------------------------");
            System.out.println(b);
        }
    }

    // Borrow Book
    public void borrowBook(int bookCode, int memberId) {

        LibraryBook selectedBook = null;
        Member selectedMember = null;

        for (LibraryBook b : bookList) {
            if (b.getBookCode() == bookCode) {
                selectedBook = b;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Book not found.");
            return;
        }

        for (Member m : memberList) {
            if (m.getMemberId() == memberId) {
                selectedMember = m;
                break;
            }
        }

        if (selectedMember == null) {
            System.out.println("Member not found.");
            return;
        }

        if (selectedBook.isBorrowed()) {
            System.out.println("Book is already issued.");
            return;
        }

        selectedBook.setBorrowed(true);

        BorrowRecord record = new BorrowRecord(bookCode, memberId);
        borrowList.add(record);

        System.out.println("Book borrowed successfully.");
    }

    // Return Book
    public void submitBook(int bookCode, int memberId) {

        for (BorrowRecord record : borrowList) {

            if (record.getBookCode() == bookCode &&
                    record.getMemberId() == memberId &&
                    record.getSubmittedDate() == null) {

                record.submitBook();

                for (LibraryBook b : bookList) {
                    if (b.getBookCode() == bookCode) {
                        b.setBorrowed(false);
                        break;
                    }
                }

                System.out.println("Book returned successfully.");
                System.out.println("Fine Amount : ₹" + record.getFineAmount());
                return;
            }
        }

        System.out.println("Borrow record not found.");
    }

    // Remove Book
    public void removeBook(int bookCode) {

        for (int i = 0; i < bookList.size(); i++) {

            LibraryBook book = bookList.get(i);

            if (book.getBookCode() == bookCode) {

                if (book.isBorrowed()) {
                    System.out.println("Cannot remove. Book is currently issued.");
                    return;
                }

                bookList.remove(i);
                System.out.println("Book removed successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Display Members
    public void displayMembers() {

        if (memberList.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        for (Member member : memberList) {
            System.out.println("----------------------------");
            System.out.println(member);
        }
    }

    // Display Borrow Records
    public void displayBorrowRecords() {

        if (borrowList.isEmpty()) {
            System.out.println("No borrow records available.");
            return;
        }

        for (BorrowRecord record : borrowList) {
            System.out.println("----------------------------");
            System.out.println(record);
        }
    }
}