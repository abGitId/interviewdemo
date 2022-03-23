package com.example.interviewdemo.programs;

public class TestPrime {
  public static void main(String[] args) {

    int input = 14;
    int i = 2;
    boolean primeNo = true;
    while (i <= input / 2) {
      if (input % i == 0) {
        primeNo = false;
        break;
      }

      i++;
    }
    if (primeNo) {
      System.out.println("input is prime number = " + input);
    } else System.out.println("input is prime not number = " + input);
  }
}
