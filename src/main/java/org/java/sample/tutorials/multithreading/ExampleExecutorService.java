package org.java.sample.tutorials.multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExampleExecutorService implements ExampleMultithreading {

  private List<Future<Integer>> getFutures() {
    List<Future<Integer>> futuresList = new LinkedList<>();
    Random randomGenerator = new Random();
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i=0; i<25; i++) {
      Callable<Integer> worker = () -> {
        Thread.sleep(randomGenerator.nextInt(3000));
        return Math.abs(randomGenerator.nextInt(2000));
      };
      Future<Integer> futureReference = executorService.submit(worker);
      futuresList.add(futureReference);
    }
    return futuresList;
  }

  @Override
  public void execute() {
    List<Future<Integer>> futureList = getFutures();
    for (Future<Integer> future : futureList) {
      try {
        Integer data = future.get();
        System.out.println(data);
      } catch (InterruptedException | ExecutionException e) {
        System.err.println(e);
      }
    }
  }
}
