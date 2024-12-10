//package com.quest.collections_pending.funcInterface;
//
//import com.quest.collections_pending.Employee;
//
//import java.util.function.Consumer;
//
//public class Java8Examples {
//
//    public static void main(String[] args) {
//
//     /*   ProcessEmployee processEmployee = new ProcessEmployeeImpl(); //inhertance
//        processEmployee.processEmployee(EmployeeProcessor.getEmployee());
//        processEmployee.processEmployee1(EmployeeProcessor.getEmployee());*/
//
//
//        //impl on the fly- anonyms class
//       /* ProcessEmployee processEmployee1 = new ProcessEmployee() {
//            @Override
//            public void processEmployee(Employee e) {
//                System.out.println("in anonyms class processEmployee : " + e);
//            }
//
//            @Override
//            public void processEmployee1(Employee e) {
//                System.out.println("in anonyms class processEmployee1 : " + e);
//
//            }
//        };
//        processEmployee1.processEmployee(EmployeeProcessor.getEmployee());
//        processEmployee1.processEmployee1(EmployeeProcessor.getEmployee());*/
//
//        /*ProcessEmployee processEmployee = new ProcessEmployee() {
//            @Override
//            public void processEmployee(Employee e) {
//                System.out.println("e : " + e);
//            }
//        };
//        processEmployee.processEmployee(EmployeeProcessor.getEmployee());
//
//        // for function interface only
//        // () -> {}
//        ProcessEmployee processEmployee1 = (e) -> {
//            System.out.println("labmda e : " + e);
//        };
//        processEmployee1.processEmployee(EmployeeProcessor.getEmployee());*/
//
//
//        Consumer<Employee> employeeConsumer = (e) -> {
//            System.out.println("consumer e : " + e);
//        };
//        callconsumer(employeeConsumer);
//        EmployeeProcessor.processEmployeeUsingDef(employeeConsumer);
//    }
//
//
//    private  static void callconsumer(Consumer<Employee> employeeConsumer) {
//        employeeConsumer.accept(EmployeeProcessor.getEmployee());
//    }
//
//}
