package com.example.interviewdemo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamMap {
  public static void main(String[] args) {
    // DO MULTIPLE OF 5 FOR INPUT OF EACH ELEMENT IN LIST
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("intList = " + intList);
    List<Integer> intListMultipleOfFive =
        intList.stream().map(i -> i * 5).collect(Collectors.toList());
    System.out.println("intListMultipleOfFive = " + intListMultipleOfFive);

    // FIND OCCURRENCE OF I IN BELOW STRING
    String inputStr = "india is my country";
    IntStream chars = inputStr.chars();
    IntStream charsPrint = inputStr.chars();
    charsPrint.forEach(System.out::println);
    long count = chars.mapToObj(c -> (char) c).filter(c -> c.equals('i')).count();
    /*  char[] chars = inputStr.toCharArray();
    Stream.of(chars)
        .filter(
            c -> {
              System.out.println("c = " + c);
              return true;
            }).count();*/
    // -- .filter(c -> c.equals('i')).count();

    System.out.println("\n inputStr = " + inputStr);
    System.out.println("count of occurrence of i= " + count);
  }
}
