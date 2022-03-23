package com.example.interviewdemo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambda {

  public static void main(String[] args) {
    TestLambda testLambda = new TestLambda();
    List<User> users = testLambda.getUsers();
    users.forEach(System.out::println);

    Comparator<User> userByAgeComparator =
        (user1, user2) -> Integer.compare(user2.getAge(), user1.getAge());

    Comparator<User> userByNameComparator =
        (user1, user2) -> user1.getName().toLowerCase().compareTo(user2.getName().toLowerCase());

    Comparator<User> userByCityComparator = Comparator.comparing(User::getCity);

    Comparator<User> userByNameAndAgeComparator =
        userByNameComparator.thenComparing(userByAgeComparator);

    //    Collections.sort(users, userByAgeComparator);
    //    System.out.println("after sort by userByAgeComparator \n");
    //    users.forEach(System.out::println);
    //    Collections.sort(users, userByNameComparator);
    //    System.out.println("after sort by userByNameComparator \n");
    //    users.forEach(System.out::println);

    Collections.sort(users, userByNameAndAgeComparator);
    System.out.println("after sort by userByNameAndAgeComparator \n");
    users.forEach(System.out::println);
  }

  public List<User> getUsers() {
    return Arrays.asList(
        new User("abhi", 30, "satara"),
        new User("shantanu", 29, "baramati"),
        new User("Jivan", 31, "pune"),
        new User("ab", 30, "satara"),
        new User("abhi", 29, "satara"),
        new User("rohit", 29, "baramati"));
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class User {
    private String name;
    private int age;
    private String city;
  }
}
