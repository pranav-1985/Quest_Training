package com.quest.oops.abstraction;

public class AbstractionExample {
    public static void displayStudentDetails(Student student) {
        student.attendClass();
        student.submitAssignment();
        student.study();
    }

    public static void main(String[] args) {
        Student online = new OnlineStudent();
        displayStudentDetails(online);
        Student offline = new OfflineStudent();
        
        Student regular = new RegularStudent();
        displayStudentDetails(regular);
        displayStudentDetails(offline);

//        online.attendClass();
//        online.submitAssignment();
//        online.study();//goes in abstract class
//
//        offline.attendClass();
//        offline.submitAssignment();
//
//        regular.attendClass();
//        regular.submitAssignment();


//        Student onlineStudent = StudentFactory.getStudent("online");
//        Student offlineStudent = StudentFactory.getStudent("offline");
//        Student regularStudent = StudentFactory.getStudent("regular");
//        onlineStudent.attendClass();
//        offlineStudent.attendClass();
//        regularStudent.attendClass();
//        onlineStudent.submitAssignment();
//        offlineStudent.submitAssignment();
//        regularStudent.submitAssignment();
    }

}
