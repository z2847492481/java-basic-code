package com.zhq.juc;

import java.util.concurrent.CompletableFuture;

/**
 * 这个例子涉及到 CompletableFuture 的 深度优先遍历去执行thenApply任务
 *
 * @author zhq123
 * @date 2025/10/24
 **/
public class CompletableFutureTest {
    public static void main(String[] args) {
        //创建初始 CompletableFuture
        CompletableFuture<String> cf = new CompletableFuture<>();

        //创建第一条任务链
        CompletableFuture<String> chain1 = cf.thenApply(s -> {
            System.out.println("Chain 1 Task 1: " + s);
            return s + "扬";
        });

        CompletableFuture<String> chain2 = chain1.thenApply(s -> {
            System.out.println("Chain 2 Task 2: " + s);
            return s;
        });

        chain1.thenApply(s -> {
            System.out.println("Chain 11 Task 11: " + s);
            return s;
        });

        CompletableFuture<String> chain3 = chain2.thenApply(s -> {
            System.out.println("Chain 3 Task 3: " + s);
            return s + "扬";
        });

        chain3.thenApply(s -> {
            System.out.println("Chain 33 Task 33: " + s);
            return s + "扬";
        });

        chain3.thenApply(s -> {
            System.out.println("Chain 333 Task 333: " + s);
            return s + "扬";
        });

        chain2.thenApply(s -> {
            System.out.println("Chain 22 Task 22: " + s);
            return s + "扬";
        });


        //触发任务链执行
        cf.complete("陈清风");
    }
}
