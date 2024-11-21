package com.quest.oops.LibraryManagementSystem;

public class PremiumMember extends Member {

    private final int BOOK_LIMIT = 14;
    private final int DAY_LIMIT = 21;

    public PremiumMember(String memberId, String name, String contactInfo, String membershipType) {
        super(memberId, name, contactInfo);
        String[][] books = new String[BOOK_LIMIT][2];
        this.setBorrowedBooks(books);
        this.setMembershipType(membershipType);
    }

    public int getDAY_LIMIT() {
        return DAY_LIMIT;
    }

    public int getBOOK_LIMIT() {
        return BOOK_LIMIT;
    }

    @Override
    public int getDayLimit() {
        return getDAY_LIMIT();
    }

    @Override
    public int getBorrowLimit() {
        return getBOOK_LIMIT();
    }
}
