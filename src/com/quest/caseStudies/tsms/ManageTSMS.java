package com.quest.caseStudies.tsms;

public interface ManageTSMS {

    void addSubscriber(Subscriber subscriber);

    void addCallRecord(int subscriberId, CallHistory callRecord);

    void getSubscriber(int subscriberId);

    void getCallHistory(int subscriberId);

    void getAllSubscribers();

    void generatePostpaidBill();

    void saveDataToFile(String filename);

    void loadDataFromFile(String filename);
}
