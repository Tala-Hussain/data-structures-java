package com.queuebystack;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public QueueUsingStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void enqueue(int item) {
        stack.push(item);
    }

    public Integer dequeue() {
        if (tempStack.isEmpty()) {
            transferStack();
        }
        if (tempStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return tempStack.pop();
    }

    public Integer peek() {
        if (tempStack.isEmpty()) {
            transferStack();
        }
        if (tempStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return tempStack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && tempStack.isEmpty();
    }

    public String printQueue() {
        if (tempStack.isEmpty()) {
            transferStack();
        }

        Stack<Integer> temp = new Stack<>();
        temp.addAll(tempStack);

        StringBuilder str = new StringBuilder("[");
        while (!temp.isEmpty()) {
            str.append(temp.pop());
            if (!temp.isEmpty()) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public String toString() {
        return printQueue();
    }

    private void transferStack() {
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
    }

}
