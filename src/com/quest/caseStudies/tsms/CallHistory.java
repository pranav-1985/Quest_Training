package com.quest.caseStudies.tsms;


import java.io.Serializable;
import java.time.LocalDateTime;

public class CallHistory implements Serializable {
    private CallType typeOfCall;
    private Double duration;
    private LocalDateTime timeStamp;

    public CallHistory(String typeOfCall, double duration, LocalDateTime timeStamp) {
        setTypeOfCall(typeOfCall);
        setDuration(duration);
        setTimeStamp(timeStamp);
    }

    public CallType getTypeOfCall() {
        return this.typeOfCall;
    }

    public void setTypeOfCall(String typeOfCall) {
        this.typeOfCall = CallType.fromString(typeOfCall);
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

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
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
