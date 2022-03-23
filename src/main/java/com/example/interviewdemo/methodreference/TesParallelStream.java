package com.example.interviewdemo.methodreference;

import java.util.Arrays;
import java.util.List;

public class TesParallelStream {

  public static void main(String[] args) {

    List<Employee> employeeList = Employee.getEmployeeList();
    System.out.println("=====sequential stream execution=====");

    Long startTime = System.currentTimeMillis();
    employeeList.stream().filter(emp -> emp.getAge() > 26).forEach(System.out::println);
    Long endTime = System.currentTimeMillis();

    Long totalTimeRequired = endTime - startTime;
    System.out.println(
        "Time required to filter Employee using sequential stream in millis:" + totalTimeRequired);

    System.out.println("=====Parallel stream execution=====");

    startTime = System.currentTimeMillis();
    employeeList.parallelStream().filter(emp -> emp.getAge() > 26).forEach(System.out::println);
    endTime = System.currentTimeMillis();
    totalTimeRequired = endTime - startTime;
    System.out.println(
        "Time required to filter Employee using Parallel stream in millis:" + totalTimeRequired);
  }
}

class Employee {
  private int id;
  private String name;
  private int age;

  public Employee(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public static List<Employee> getEmployeeList() {

    return Arrays.asList(
        new Employee(1, "Emp1", 29),
        new Employee(2, "Emp1", 29),
        new Employee(3, "Emp2", 25),
        new Employee(4, "Emp3", 29),
        new Employee(5, "Emp4", 27),
        new Employee(6, "Emp5", 26),
        new Employee(7, "Emp6", 28),
        new Employee(8, "Emp7", 28),
        new Employee(9, "Emp8", 25),
        new Employee(10, "Emp9", 27));
  }
}
