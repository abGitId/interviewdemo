package com.example.interviewdemo.programs;
/*
 * The Fibonacci series is a series where the next term is the sum of the previous two terms.
 * The first two terms of the Fibonacci sequence are 0 followed by 1.
 *  Fibonacci Series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
 * */
public class TestFibonacci {

  public static void main(String[] args) {
    int i = 0, n = 10, firstNo = 0, secondNo = 1;

    while (i <= n) {
      System.out.print(firstNo + ", ");
      int nextNo = firstNo + secondNo;
      firstNo = secondNo;
      secondNo = nextNo;
      i++;
    }
  }
}
