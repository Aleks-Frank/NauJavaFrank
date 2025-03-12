package org.example.SreamAPI;

import java.util.ArrayList;
import java.util.Arrays;

public class Employee {

    private String fullName;

    private int age;

    private String department;

    private double salary;

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String fullName, int age, String department, double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "имя - " + fullName +
                ", возраст - " + age +
                ", отдел - " + department +
                ", зарплата - " + salary;
    }

    public static void showList(ArrayList<Employee> list){
        list.forEach(System.out::println);
    }

}
