package com.circulerqueue;

public class CircularQueueArray<T> {

    private final T[] arr;
    private int front, rear;
    private int size;

    public CircularQueueArray(int capasity) {
        this.size = capasity;
        this.arr = (T[]) new Object[capasity];
        this.front = -1;
        this.rear = -1;

    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = item;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T item = arr[front];
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;

        }
        return item;

    }

    public T front() {
        if (isEmpty()) {
            return null;
        } else {
            return arr[front];
        }
    }

    public T rear() {
        if (isEmpty()) {
            return null;
        } else {
            return arr[rear];
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public String print() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder s = new StringBuilder("[");
        for (int i = front;; i = (i + 1) % size) {
            s.append(arr[i]);
            if (i == rear) {
                break;
            }
            s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

    @Override
    public String toString() {
        return print();
    }
}
