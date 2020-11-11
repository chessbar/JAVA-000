package com.blackberry.javastudy.homework.week4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            Thread.sleep(1000L);
            return "hello world!";
        };
        FutureTask<String> task = new FutureTask<>(callable);
        new Thread(task).start();
        String result = task.get();
        System.out.println(result);
    }
}

class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<String> callable = () -> {
            Thread.sleep(1000L);
            return "hello world!";
        };
        Future<String> future = executorService.submit(callable);
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }
}


