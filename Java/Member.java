import java.time.LocalDate;

public class Member {

    private int memberId;
    private String memberName;
    private String department;
    private String contactNumber;
    private LocalDate joiningDate;

    public Member(int memberId, String memberName, String department, String contactNumber) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.department = department;
        this.contactNumber = contactNumber;
        this.joiningDate = LocalDate.now();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getDepartment() {
        return department;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Member ID : " + memberId +
                "\nName      : " + memberName +
                "\nDepartment: " + department +
                "\nContact   : " + contactNumber +
                "\nJoined On : " + joiningDate;
    }
}