package com.zhq.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhq123
 * @date 2025/9/27
 **/
public class GenericsTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add(1);
        System.out.println(list);
    }
}
