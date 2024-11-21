package com.quest.oops.LibraryManagementSystem;

public class NormalMember extends Member {

    private final int BOOK_LIMIT = 7;
    private final int DAY_LIMIT = 14;

    public NormalMember(String memberId, String name, String contactInfo, String membershipType) {
        super(memberId, name, contactInfo);
        String[][] books = new String[BOOK_LIMIT][2];
        this.setBorrowedBooks(books);
        this.setMembershipType(membershipType);
    }

    public int getBOOK_LIMIT() {
        return BOOK_LIMIT;
    }

    public int getDAY_LIMIT() {
        return DAY_LIMIT;
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
