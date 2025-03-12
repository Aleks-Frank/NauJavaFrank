package org.example.SreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WorkWithEmployee {

    public static ArrayList<Employee> list;

    public static void createFiveEmployees(){
        Employee employee1 = new Employee("Александр Мирон Александрович", 34, "Разработка", 35000.0);
        Employee employee2 = new Employee("Иван Иванов Иванович", 23, "Разработка", 40000.0);
        Employee employee3 = new Employee("Петр Петров Петрович", 31, "HR-отдел", 67000.0);
        Employee employee4 = new Employee("Эльвира Эваль Маркович", 28, "Разработка", 20000.0);
        Employee employee5 = new Employee("Семен Семенов Семенович", 21, "Охрана", 11000.0);

        list = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee4, employee5));
    }

    public static void showNameAndDepList(){
        list.stream()
                .map(employee -> employee.getFullName() + "-" + employee.getDepartment())
                .forEach(System.out::println);
    }



}
