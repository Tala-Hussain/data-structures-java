package com.myqueue;

public class QueueByLinked<D> {

    class Node<D> {

        D item;
        Node<D> next;

        public Node(D item) {
            this.item = item;
            this.next = null;
        }
    }
    private Node<D> front;
    private Node<D> rear;
    private int size;

    public QueueByLinked() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(D item) { //addLast
        Node<D> nNode = new Node<>(item);
        if (rear == null) {
            front = nNode;
            rear = nNode;
        } else {
            rear.next = nNode;
            rear = nNode;
        }
        size++;
    }

    public D dequeue() { //removeFirst
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        D item = front.item;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return item;
    }

    public D peek() { //getFirst
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.item;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String print() {
        String str = "[";
        if (rear == null) {
            return "[]";
        } else {
            Node<D> curr = front;
            while (curr != null) {
                str += curr.item + ", ";
                curr = curr.next;
            }
        }
        return str.substring(0, str.length() - 2) + "]";
    }

    @Override
    public String toString() {
        return print();
    }

}
