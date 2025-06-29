package com.zhq.chain;

public class BeforeInterceptorImpl implements Interceptor {

    @Override
    public Object invoke(InterceptorChain chain) {
        System.out.println("before");
        return chain.proceed();
    }
}
