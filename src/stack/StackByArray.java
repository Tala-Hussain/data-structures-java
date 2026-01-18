package com.mystack2;

public class StackByArray<T> {

    private T[] arr;

    private int top;

    public StackByArray() {
        arr = (T[]) new Object[8];
        top = -1;
    }

    public void push(T element) {
        if (isFull()) {
            ensureCapacity(arr.length * 2);
        }
        arr[++top] = element;

    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        T element = arr[top];
        arr[top--] = null;
        return element;
    }

    private void ensureCapacity(int nSize) {
        T[] nArray = (T[]) new Object[nSize];
        System.arraycopy(arr, 0, nArray, 0, arr.length);
        arr = nArray;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return arr[top];

    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            arr[i] = null;
        }
        top = -1;
    }

    public void reverse() {
        int left = 0;
        int right = top;
        while (left < right) {
            T temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public void merge(StackByArray<T> other) {
        if (other == null || other.isEmpty()) {
            return;
        }
        while (arr.length < this.size() + other.size()) {
            ensureCapacity(arr.length * 2);
        }
        for (int i = 0; i <= other.top; i++) {
            push(other.arr[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(arr[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
