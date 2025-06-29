package com.zhq.chain;

public interface Interceptor {

    Object invoke(InterceptorChain chain);
}
