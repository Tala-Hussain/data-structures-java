package com.circulerlinked2;

public class Circuler<D> {

    class Node<D> { // head class

        D item;
        Node<D> next;

        public Node(D item) {
            this.item = item;
            this.next = null;
        }

    }
    private Node<D> head;
    private Node<D> tail;
    int size;

    public Circuler() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(D item) {
        Node<D> nNode = new Node<>(item);
        if (head == null) {
            head = tail = nNode;
            nNode.next = head;
        } else {
            nNode.next = head;
            head = nNode;
            tail.next = head;
        }
        size++;
    }

    public void add(D item) {
        Node<D> nNode = new Node<>(item);
        if (head == null) {
            head = tail = nNode;
            nNode.next = head;
        } else {
            tail.next = nNode;
            tail = nNode;
            tail.next = head;
        }
        size++;
    }

    public void addIndex(int index, D item) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        Node<D> nNode = new Node<>(item);
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            add(item);
        } else {
            Node<D> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            nNode.next = curr.next;
            curr.next = nNode;
        }
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;

    }

    public void removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node<D> curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            curr.next = head;
            tail = curr;
        }
        size--;

    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<D> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String print() {
        String str = "[";
        if (head == null) {
            return "[]";
        } else {
            Node<D> curr = head;
            do {
                str += curr.item + ", ";
                curr = curr.next;
            } while (curr != head); 
        }
        return str.substring(0, str.length() - 2) + "]";
    }

    @Override
    public String toString() {
        return print();
    }

}
