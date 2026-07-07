public class LibraryBook {

    private int bookCode;
    private String bookTitle;
    private String authorName;
    private String category;
    private String rackNumber;
    private boolean borrowed;

    public LibraryBook(int bookCode, String bookTitle, String authorName,
                       String category, String rackNumber) {
        this.bookCode = bookCode;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.category = category;
        this.rackNumber = rackNumber;
        this.borrowed = false;
    }

    public int getBookCode() {
        return bookCode;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getCategory() {
        return category;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book Code : " + bookCode +
                "\nTitle     : " + bookTitle +
                "\nAuthor    : " + authorName +
                "\nCategory  : " + category +
                "\nRack No   : " + rackNumber +
                "\nStatus    : " + (borrowed ? "Issued" : "Available");
    }
}