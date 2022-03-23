package com.example.interviewdemo.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestBlockingArrayQueue {

  public static void main(String[] args) throws InterruptedException {
    //

    BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);

    /*
          arrayBlockingQueue.add("1");
          arrayBlockingQueue.add("2");
          System.out.println("arrayBlockingQueue = " + arrayBlockingQueue);
          arrayBlockingQueue.add("3");
    */

    arrayBlockingQueue.put("1");
    arrayBlockingQueue.put("2");
    System.out.println("arrayBlockingQueue = " + arrayBlockingQueue);
    arrayBlockingQueue.put("3");

      arrayBlockingQueue.remove();
      System.out.println("arrayBlockingQueue = " + arrayBlockingQueue);
  }
}
