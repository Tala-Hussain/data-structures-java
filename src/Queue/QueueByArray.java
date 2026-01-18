package com.myqueue2;

public class QueueByArray<T> {
    private T[] arr;
    private int front;
    private int rear;
    private int maxSize;
    private int nItem;

    public QueueByArray(int capasity) {
         this.maxSize = capasity;
        this.arr = (T[]) new Object[maxSize];
        this.front =0;
        this.rear = -1;
       this.nItem=0;
       

    }

    public void enqueue(T element) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % maxSize;
        arr[rear] = element;
        nItem++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T element = arr[front];
        arr[front] = null;
        front = (front + 1) % maxSize;
        nItem--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return nItem == 0;
    }

    public boolean isFull() {
        return  nItem==maxSize;
    }

    public int size() {
        return  nItem;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nItem; i++) {
             sb.append(arr[(front +i)%maxSize]);
            if (i < nItem - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return print();
    }
}
