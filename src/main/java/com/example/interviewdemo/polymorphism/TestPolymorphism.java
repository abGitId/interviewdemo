package com.example.interviewdemo.polymorphism;

public class TestPolymorphism {

  public static void main(String[] args) {

      Parent p = new Child();
      p.display();
    System.out.println("p.c = " + p.className);
  }
}

class Parent {

    public static String className="Parent";
  static void display() {
    System.out.println("calling from Parent.display");
  }
}

class Child extends Parent {

    public static String className="Child";
  static void display() {
    System.out.println("calling from Child.display");
  }
}
