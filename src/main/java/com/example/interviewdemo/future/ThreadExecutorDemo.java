package com.example.interviewdemo.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadExecutorDemo {

  public static void main(String[] args) {
    //
    ExecutorService service = Executors.newFixedThreadPool(10);

    IntStream.range(0,6)
        .forEach(
            i -> {
              Thread thread = new Thread(threadNameTask);
              thread.setName("Thread-" + i);
              thread.start();
            });
    System.out.println(
        "MAIN hread.currentThread().getName() = " + Thread.currentThread().getName());
  }

  static Runnable threadNameTask = ThreadExecutorDemo::run; // method reference

  private static void run() {
    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
  }
}
