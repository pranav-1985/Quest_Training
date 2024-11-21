package com.quest.oops.LibraryManagementSystem;

import java.util.Arrays;

public class Member {
    private String memberId;
    private String name;
    private String contactInfo;
    private String membershipType;
    private String[][] borrowedBooks;
    private int borrowedCount;
    private final int LATE_FINE = 10;

    public Member(String memberId, String name, String contactInfo) {
        this.memberId = memberId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedCount = 0;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String[][] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(String[][] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void setBorrowedCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }

    public int getLATE_FINE() {
        return LATE_FINE;
    }

    public int getDayLimit() {
        return 0;
    }

    public int getBorrowLimit() {
        return 0;
    }

    @Override
    public String toString() {
        return """
                Member{
                Member ID='%s',
                Name='%s',
                Contact Info='%s',
                Membership Type='%s',
                Borrowed Books= [%s],
                }
                """.formatted(memberId, name, contactInfo, membershipType, Arrays.deepToString(borrowedBooks));
    }

}
