package com.zhq.thread;

import java.util.concurrent.*;

public class ThreadPoolBasicDemo {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,                      // 核心线程数
            4,                      // 最大线程数
            60L,                    // 空闲线程存活时间
            TimeUnit.SECONDS,       // 时间单位
            new LinkedBlockingQueue<>(100),  // 任务队列
            Executors.defaultThreadFactory(), // 线程工厂
            new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
        );

        // 提交任务
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}