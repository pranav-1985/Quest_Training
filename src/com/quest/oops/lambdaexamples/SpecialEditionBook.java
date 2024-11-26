package com.quest.oops.lambdaexamples;

public class SpecialEditionBook extends Book {

    private String specialFeature;

    public SpecialEditionBook(String title, String author, int price, int stock, String specialFeature) {
        super(title, author, price, stock);
        this.specialFeature = specialFeature;
    }

    public String getSpecialEditionType() {
        return specialFeature;
    }

    public void setSpecialEditionType(String specialEditionType) {
        this.specialFeature = specialEditionType;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Special Edition Type: " + getSpecialEditionType() + "\n";
    }
}
