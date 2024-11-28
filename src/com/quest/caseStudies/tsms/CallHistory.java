package com.quest.caseStudies.tsms;


public class CallHistory {
    private String typeOfCall;
    private Double duration;
    private String timeStamp;

    public CallHistory(String typeOfCall, double duration, String timeStamp) {
        setTypeOfCall(typeOfCall);
        setDuration(duration);
        setTimeStamp(timeStamp);
    }

    public String getTypeOfCall() {
        return this.typeOfCall;
    }

    public void setTypeOfCall(String typeOfCall) {
        if (typeOfCall == null || !(typeOfCall.equalsIgnoreCase("Local") || typeOfCall.equalsIgnoreCase("ISD") || typeOfCall.equalsIgnoreCase("STD"))) {
            throw new IllegalArgumentException("Type of call must be either 'STD','Local' or 'ISD'.");
        }
        this.typeOfCall = typeOfCall;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Duration must not be 0 minutes");
        }
        this.duration = duration;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        if (timeStamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return String.format("CallHistory [Type: %s, Duration: %s, Timestamp: %s]", typeOfCall, duration, timeStamp);
    }

}
