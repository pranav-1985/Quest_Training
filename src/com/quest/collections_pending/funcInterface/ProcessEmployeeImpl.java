package com.quest.collections_pending.funcInterface;

import com.quest.collections_pending.Employee;

public class ProcessEmployeeImpl implements ProcessEmployee{

    @Override
    public void processEmployee(Employee e) {
        // a bit pf validation and processing before that
        System.out.println(e);
    }
}
