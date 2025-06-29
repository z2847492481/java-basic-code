package com.zhq.chain;

import java.util.ArrayList;
import java.util.List;

public class InterceptorChain {

    public int index = 0;

    public List<Interceptor> interceptors = new ArrayList<>();

    public Object proceed() {
        if (index < interceptors.size()) {
            return interceptors.get(index++).invoke(this);
        }
        return invokeRealMethod();
    }

    public Object invokeRealMethod() {
        System.out.println("invoke real");
        return "res";
    }
}
