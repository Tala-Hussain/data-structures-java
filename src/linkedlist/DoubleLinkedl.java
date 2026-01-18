package com.mydoubllinked;

public class DoubleLinkedl<D> {

    class Node<D> {

        D item;
        Node<D> next;
        Node<D> prev;

        Node(D item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }
    private Node<D> head;
    private Node<D> tail;

    private int size;

    public DoubleLinkedl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(D item) {
        Node<D> nNode = new Node<>(item);

        if (head == null) {
            head = tail = nNode;
            nNode.prev = nNode.next = null;
        } else {
            nNode.next = head;
            nNode.prev = null;
            head.prev = nNode;
            head = nNode;
        }
        size++;
    }

    public void add(D item) {
        Node<D> nNode = new Node<>(item);
        if (head == null) {
            head = tail = nNode;
            nNode.prev = nNode.next = null;
        } else {
            nNode.next = null;
            nNode.prev = tail;
            tail.next = nNode;
            tail = nNode;
        }
        size++;
    }

    public void addByindex(int index, D item) {
        if (index < 0 || index >= size) {
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
            nNode.prev = curr;
            curr.next = nNode;
            curr.next.prev = nNode;

        }
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }

        head.prev = null;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        } else if (size == 1) {
            tail = head = null;
        } else {
            tail = tail.prev;
            tail.next = null;

        }
        size--;
    }

    public void removeItem(D element) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (head.item == element) {
            removeFirst();
        } else {
            Node<D> curr = head.next;
            while (curr != null && curr.item != element) {
                curr = curr.next;

            }
            if (curr == null) {
                System.out.println("Element is not found");
            } else if (curr.next == null) {
                removeLast();
            } else {
                curr.next.prev = curr.prev;
                curr.prev.next = curr.next;
            }
            size--;
        }
    }

    public void removeIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            removeFirst();

        } else if (index == size) {
            removeLast();
        } else {
            Node<D> curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            if (curr.next == null) {
                removeLast();
            } else {
                curr.next.prev = curr.prev;
                curr.prev.next = curr.next;
            }
        }
        size--;
    }

    public void reverse() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        Node<D> curr = tail;
        Node<D> temp = null;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;

        }
        if (temp != null) {
            head = temp.prev;
            tail = temp.next;
        }
    }

    public D getFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        return head.item;
    }

    public D getLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }
        return tail.item;
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
