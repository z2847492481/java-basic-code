package com.zhq.queue;

import java.lang.reflect.Array;

/**
 * @author zhq123
 * @date 2025/9/6
 **/
public class ArrayQueue<T> {

    private T[] array;

    private int front = 0;

    private int rear = 0;

    public ArrayQueue(Class<T> clazz, int capacity) {
        this.array = (T[]) Array.newInstance(clazz, capacity + 1);
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (rear + 1) % array.length == front;
    }

    public void enqueue(T t) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        array[rear] = t;
        rear = (rear + 1) % array.length;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        T t = array[front];
        front = (front + 1) % array.length;
        return t;
    }
}
