package com.quest.caseStudies.tsms;

public enum CallType {
    LOCAL(1),
    STD(2),
    ISD(5);

    private final int rate;

    CallType(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public static CallType fromString(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Call type cannot be null.");
        }
        switch (type.toUpperCase()) {
            case "LOCAL":
                return LOCAL;
            case "STD":
                return STD;
            case "ISD":
                return ISD;
            default:
                throw new IllegalArgumentException("Unknown call type: " + type);
        }
    }
}
