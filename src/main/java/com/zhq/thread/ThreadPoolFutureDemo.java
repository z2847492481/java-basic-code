package com.zhq.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolFutureDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100)
        );

        List<Future<Integer>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();
        // 提交返回结果的任务
        for (int i = 0; i < 4; i++) {
            final int taskId = i;
            Future<Integer> future = executor.submit(() -> {
                Thread.sleep(1000);
                return taskId * 2;
            });
            futures.add(future);
        }

        // 获取任务结果
        for (Future<Integer> future : futures) {
            try {
                Integer result = future.get(2, TimeUnit.SECONDS);
                System.out.println("Task result: " + result);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        executor.shutdown();
    }
}