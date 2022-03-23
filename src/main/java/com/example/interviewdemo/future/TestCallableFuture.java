package com.example.interviewdemo.future;

import java.util.Random;
import java.util.concurrent.*;

/*
 * CompletableFuture :
 * - it is used to perform async computation & trigger dependant computation which can be also async
 *
 * callable/ future:
 * If thread which have something to return then we use callable
 * and to achieve this we required the ExecutorService
 * */
public class TestCallableFuture {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    // here we are submitting Task and accept the placeholder object for return value
    // so this is async call will execute and till then we can execute other task and wherever we
    // required the future value we can get from the future placeholder
    Future<Integer> future = executorService.submit(callableTask2);


    //
    try {
      // get the task return value
      Integer result =
          future
              .get(); // blocking i.e if we call the future.get method before result computation then
                      // main thread got block
      //-- or we can use
      //-- Integer result = future.get(200, TimeUnit.MILLISECONDS);

      System.out.println("Result from the task = " + result);
    } catch (InterruptedException | ExecutionException /*| TimeoutException*/ e) {
      e.printStackTrace();
    }

    // executorService.shutdown();
    // With this approach, the ExecutorService will first stop taking new tasks and then wait up to
    // a specified period of time for all tasks to be completed. If that time expires, the execution
    // is stopped immediately
    try {
      if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
    }

    //-- CompletableFuture.supplyAsync().then
    Thread t1 = new Thread(task);
    Thread t2 = new Thread(task);
    t1.start();
    t2.start();
  }

  static Runnable task =()-> System.out.println("true = " + Thread.currentThread().getPriority());
  static Callable<Integer> callableTask1 =()-> new Random().nextInt();
  static Callable<Integer> callableTask2 =
      () -> {
        System.out.println("task = " + task);
        return new Random().nextInt();
      };
}



class Task implements Callable<Integer> {

  // here we are just returning the random no. as result
  @Override
  public Integer call() throws Exception {
    return new Random().nextInt();
  }
}
