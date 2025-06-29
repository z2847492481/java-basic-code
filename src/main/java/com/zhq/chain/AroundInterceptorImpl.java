package com.zhq.chain;

public class AroundInterceptorImpl implements Interceptor {
    @Override
    public Object invoke(InterceptorChain chain) {
        System.out.println("around before");
        try {
            return chain.proceed();
        } finally {
            System.out.println("around after");
        }
    }
}
