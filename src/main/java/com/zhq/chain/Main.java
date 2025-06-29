package com.zhq.chain;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InterceptorChain chain = new InterceptorChain();
        chain.interceptors = new ArrayList<>();
        chain.interceptors.add(new BeforeInterceptorImpl());
        chain.interceptors.add(new AroundInterceptorImpl());
        System.out.println(chain.proceed());
    }
}
