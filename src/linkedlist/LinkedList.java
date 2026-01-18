package com.mylinkedlist3;

public class LinkedList<D> {

    class Node<D> {

        D item;
        Node<D> next;

        Node(D item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node<D> head;
    private Node<D> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(D item) { //addlast;

        Node<D> nNode = new Node<>(item);

        if (tail == null) {
            head = nNode;
            tail = nNode;

        } else {
            tail.next = nNode;
            tail = nNode;

        }
        size++;

    }

    public void addFirst(D item) {
        Node<D> nNode = new Node<>(item);

        nNode.next = head;
        head = nNode;

        if (size == 0) {
            tail = nNode;
        }
        size++;
    }

    public void add(int index, D item) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            add(item);
        } else {
            Node<D> nNode = new Node<>(item);
            Node<D> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            nNode.next = curr.next;
            curr.next = nNode;
            size++;
        }
    }

    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
    }

    public void remove(D element) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        Node<D> curr, prev;
        if (head.item == element) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else {
            prev = head;
            curr = head.next;
            while (curr != null && curr.item != element) {
                prev = curr;
                curr = curr.next;
            }
            if (curr == null) {
                System.out.println("Element not found");
            } else {
                prev.next = curr.next;
                if (tail == curr) {
                    tail = prev;
                }
                size--;
            }
        }
    }  

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size) {
            removeLast();
        } else {
            Node<D> prev = head;
            Node<D> curr = head.next;
            for (int i = 0; i < index - 1; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            if (tail==curr) {
                tail = prev;
            }
            size--;
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

    public D get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        Node<D> curr = head;
        if (index == 0) {
            getFirst();
        } else if (index == size) {
            getLast();
        } else {

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        }
        return curr.item;
    }

    public void removeLast() {

        if (head == null) {
            throw new RuntimeException("List is empty");
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {

            Node<D> curr = head.next;
            Node<D> prev = head;
            while (curr != tail) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            tail = prev;
            size--;
        }
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node<D> prev = null;
        Node<D> curr = head;
        Node<D> next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeDuplicates() {
        Node curr = head;

        while (curr != null && curr.next != null) {
            Node temp = curr;

            while (temp.next != null) {
                if (curr.item == temp.next.item) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
    }

    public D getMid() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        Node<D> fast = head;
        Node<D> slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.item;
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
