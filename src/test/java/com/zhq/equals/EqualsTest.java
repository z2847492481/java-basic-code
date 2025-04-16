package com.zhq.equals;

import com.zhq.model.Cat;
import com.zhq.model.Person;
import org.junit.Test;

import java.util.HashSet;

public class EqualsTest {

    @Test
    public void test() {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("zs", 18);
        Person p2 = new Person("zs", 18);
        set.add(p1);
        set.add(p2);
        System.out.println(set.size());
    }

    @Test
    public void test2() {
        HashSet<Cat> set = new HashSet<>();
        Cat p1 = new Cat("zs");
        Cat p2 = new Cat("zs");
        set.add(p1);
        set.add(p2);
        System.out.println(set.size());
    }
}
