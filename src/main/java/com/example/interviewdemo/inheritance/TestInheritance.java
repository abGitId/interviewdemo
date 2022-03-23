package com.example.interviewdemo.inheritance;

public class TestInheritance {
  public static void main(String[] args) {
    A a = new B();
    a.method(10, 20);

    B b = (B) a;
    b.method(10, 20);

    C c = (C) b;
    c.method(10, 20);
  }
}

class A {
  public void method(int a, int b) {
    System.out.println("in A");
  }
}

class B extends A {

  public void method(int a, int b) {
    System.out.println("in B");
  }

  public void method2(int a, int b) {
    System.out.println("in B");
  }
}

class C extends B {

  public void method(int a, int b) {
    System.out.println("in C");
  }
}
