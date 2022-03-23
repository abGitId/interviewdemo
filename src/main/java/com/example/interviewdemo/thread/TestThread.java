package com.example.interviewdemo.thread;

public class TestThread {

  public static void main(String[] args) {
    //
     // Thread thread1 = new Thread(task)
  }

  Runnable task1 = ()-> System.out.println("hello");
  Runnable task2 = ()-> System.out.println("calling from:"+Thread.currentThread().getName());
}
