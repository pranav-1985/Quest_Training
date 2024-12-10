//package com.quest.collections_pending.funcInterface;
//
//import com.quest.collections.older.Person;
//import com.quest.collections_pending.Employee;
//
//import java.util.function.Consumer;
//
//public class EmployeeProcessor {
//
//    public static void processEmployeeUsingDef(Consumer<Employee> employeeConsumer) {
//        // do something as pre()
//        employeeConsumer.accept(getEmployee());
//        // do something as post()
//    }
//
//    public static void processEmployeeUsingDef(ProcessEmployee processEmployee) {
//        // do something as pre()
//        processEmployee.processEmployee(getEmployee());
//        // do something as post()
//    }
//
//    public static void processEmployeeUsingDef(ProcessPerson processPerson) {
//        // do something as pre()
//        //processPerson.processPersoon(new Person("name",21));
//        // do something as post()
//    }
//
//    public static Employee getEmployee() {
//        //get employee from the db
//        return new Employee("Nikhil", 30,100);
//    }
//}
