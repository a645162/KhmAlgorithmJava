package com.algorithm.linerlist.queue;

public class CircleArrayQueueDemo {
}


class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }

        arr[rear] = n;

        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }

        int value = arr[front];

        front = (front + 1) % maxSize;

        return value;
    }

    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }

        for (int i = 0; i < front + getSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }

        return arr[front];
    }
}