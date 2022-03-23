package com.example.interviewdemo.exceptions;

import java.util.stream.Stream;

public class TestException {

  public static void main(String[] args) {
    //
    Object o = new Object();
    Parent parent = new Child();
    Child child = new Child();
    child.message();
    parent.message();

    System.out.println("child=" + child.age);
    System.out.println("parent" + parent.age);

    //-- child.fun1(null, null);
    child.fun1((Integer) null, null);
  }
}

class Parent {

  public int age = 50;

  public static void message() throws NullPointerException{
    System.out.println("this is a parent class");
    //-- throw new NullPointerException();
  }
}

class Child extends Parent {
  public int age = 10;

  public static void message() {
    System.out.println("this is a Child class");
  }

  public void fun1(Integer i, String s) {
    System.out.println("Child.fun1");
    System.out.println("i = " + i);
    System.out.println("s = " + s);
  }

  public void fun1(String i, String s) {
    System.out.println("Child.fun2");
    System.out.println("i = " + i);
    System.out.println("s = " + s);
  }
}
