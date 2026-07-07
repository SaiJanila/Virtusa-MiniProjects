import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowRecord {

    private int bookCode;
    private int memberId;
    private LocalDate borrowedDate;
    private LocalDate submittedDate;
    private double fineAmount;

    public BorrowRecord(int bookCode, int memberId) {
        this.bookCode = bookCode;
        this.memberId = memberId;
        this.borrowedDate = LocalDate.now();
        this.submittedDate = null;
        this.fineAmount = 0;
    }

    public int getBookCode() {
        return bookCode;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public LocalDate getSubmittedDate() {
        return submittedDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void submitBook() {
        submittedDate = LocalDate.now();

        long days = ChronoUnit.DAYS.between(borrowedDate, submittedDate);

        // First 7 days are free
        if (days > 7) {
            fineAmount = (days - 7) * 10;
        }
    }

    @Override
    public String toString() {
        return "Book Code : " + bookCode +
                "\nMember ID : " + memberId +
                "\nBorrowed  : " + borrowedDate +
                "\nReturned  : " + (submittedDate == null ? "Not Returned" : submittedDate) +
                "\nFine      : ₹" + fineAmount;
    }
}