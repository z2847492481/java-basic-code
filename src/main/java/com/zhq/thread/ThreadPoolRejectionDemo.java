package com.zhq.thread;

import java.util.concurrent.*;

public class ThreadPoolRejectionDemo {
    public static void main(String[] args) {
        // 创建一个容易触发拒绝策略的线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1,                      // 核心线程数
            2,                      // 最大线程数
            0L,                     // 空闲线程存活时间
            TimeUnit.MILLISECONDS,  // 时间单位
            new LinkedBlockingQueue<>(2),    // 很小的队列容量
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy() // 使用调用者运行策略
        );

        // 提交多个任务以触发拒绝策略
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            try {
                executor.execute(() -> {
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (RejectedExecutionException e) {
                System.out.println("Task " + taskId + " was rejected");
            }
        }

        executor.shutdown();
    }
}