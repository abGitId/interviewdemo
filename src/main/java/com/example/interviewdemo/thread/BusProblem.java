package com.example.interviewdemo.thread;

public class BusProblem {

  public static void main(String[] args) {
    Bus bus1 = new Bus();
    /*Bus bus2 = new Bus();
    Bus bus3 = new Bus();
    Bus bus4 = new Bus();
    Bus bus5 = new Bus();*/

    Thread t1 = new Thread(bus1);
    Thread t2 = new Thread(bus1);
    Thread t3 = new Thread(bus1);
    Thread t4 = new Thread(bus1);
    Thread t5 = new Thread(bus1);

    t1.setName("bus1");
    t2.setName("bus2");
    t3.setName("bus3");
    t4.setName("bus4");
    t5.setName("bus5");

    t1.start();
    t5.start();
    t3.start();
    t2.start();
    t4.start();

    try {
        t5.wait(50000);
      //t5.join(50000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      //-- t4.join(40000);
      t4.wait(40000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
        //-- t3.join(30000);
      t3.wait(30000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
        //-- t2.join(20000);
      t2.wait(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      t1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Bus implements Runnable {

  @Override
  public void run() {
    try {
     Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Destination reached by = " + Thread.currentThread().getName());
  }
}
