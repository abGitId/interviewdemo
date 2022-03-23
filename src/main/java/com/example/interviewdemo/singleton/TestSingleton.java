package com.example.interviewdemo.singleton;

import java.io.Serializable;

public class TestSingleton {

  public static void main(String[] args) {
    //
    Singleton instance = Singleton.getInstance();
    Singleton instance2 = Singleton.getInstance();
    System.out.println("instance = " + instance.hashCode());
    System.out.println("instance2 = " + instance2.hashCode());
  }
}

final class Singleton implements Serializable {

  public static Singleton instance = null;

  private Singleton() {}

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
