package org.example;

import org.example.Interface.TaskQueue;
import org.example.SreamAPI.Employee;
import org.example.SreamAPI.WorkWithEmployee;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nЗадание №1");
        WorkingWithArrays workingWithArrays = new WorkingWithArrays();
        workingWithArrays.showTaskOne(2);

        System.out.println("\nЗадание №2");
        WorkingWithList workingWithList = new WorkingWithList();
        workingWithList.sortedTest(20);

        System.out.println("\nЗадание №3");
        WorkWithEmployee.createFiveEmployees();
        WorkWithEmployee.showNameAndDepList();

        System.out.println("\nЗадание №4");
        HTTPClientAndJSON.connect();

        System.out.println("\nЗадание №5");
        TaskQueue taskQueue = new TaskQueue();
        taskQueue.testCreateTask();
        taskQueue.start();

    }

}