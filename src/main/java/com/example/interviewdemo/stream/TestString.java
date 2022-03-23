package com.example.interviewdemo.stream;

public class TestString {
  public static void main(String[] args) {
    //
      String s1 = "Hello";
      String s2 = new String(s1);
      String s3 = "Hello";

    System.out.println("s1=" + s1.hashCode());
    System.out.println("s2=" + s2.hashCode());
    System.out.println("s3=" + s3.hashCode());

    System.out.println( s1 == s2);
    System.out.println(s1 == s3);
    System.out.println("s1.equals(s2) = " + s1.equals(s2));

  }
}
