package com.mystack;

public class StackByLinked<D> {

    class Node<D> {

        D item;
        Node<D> next;
        
        public Node(D item) {
            this.item = item;
            this.next = null;
        }

    }
    private Node<D> head;
    private int size;

    public StackByLinked() {
        this.head = null;
        this.size = 0;
    }

    public void push(D item) { //addFirst;
        Node<D> nNode = new Node<>(item);
        if (head == null) {
            head = nNode;
        } else {
            nNode.next = head;
            head = nNode;
        }
        size++;
    }

    public D pop() { // removFirst in linkedList
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        D element = head.item;
        head = head.next;
        size--;
        return element;
    }

    public D peek() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return head.item;
    }

    public D getLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        Node<D> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.item;
    }

    public D get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        Node<D> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node<D> prev = null;
        Node<D> curr = head;
        Node<D> next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public D removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            return pop();
        }
        Node<D> prev = null;
        Node<D> curr = head;
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        size--;
        return curr.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

   

    public boolean contains(D item) {
        Node<D> curr = head;
        while (curr != null) {
            if (curr.item.equals(item)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public String print() {
        String str = "[";
        if (head == null) {
            return "[]";
        } else {
            Node<D> curr = head;
            do {
                str = str + curr.item + ", ";
                curr = curr.next;
            } while (curr != null);
        }
        return str.substring(0, str.length() - 2) + "]";

    }

    public void merge(StackByLinked<D> other) {
        Node<D> curr = other.head;
        while (curr != null) {
            push(curr.item);
            curr = curr.next;
        }
    }

    public void removeDuplicates() {
        Node<D> curr = head;

        while (curr != null) {
            Node<D> temp = curr;
            while (temp.next != null) {
                if (temp.next.item.equals(curr.item)) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        return print();
    }

}
