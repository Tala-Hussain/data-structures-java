package com.myarraylist;

public class ArrayList<T> {

    private T[] arr;
    private int size;

    public ArrayList() {
        arr = (T[]) new Object[8];
        size = 0;
    }

    public void add(T element) {
        if (size == arr.length) {
            resize(arr.length * 2);
        }
        arr[size++] = element;
    }

    public void add(int index, T element) {

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == arr.length) {
            resize(arr.length * 2);
        }
        shiftRight(index);
        arr[index] = element;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        shiftLeft(index);
    }

    public void remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        if (size > 0 && size < arr.length / 4) {
            resize(arr.length / 2);
        }
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T val) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] != null && arr[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        arr[index] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return arr[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        arr = (T[]) new Object[8];
        size = 0;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public void removeAll(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(element)) {
                remove(i);
                i--;
            }
        }
    }

    public void addAll(ArrayList<T> other) {
        while (other.size + this.size > arr.length) {
            resize(arr.length * 2);
        }
        for (int i = 0; i < other.size; i++) {
            this.add(other.get(i));
        }
    }

    public boolean equals(ArrayList<T> other) {
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            T thisEl = this.get(i);
            T otherEl = other.get(i);

            if (thisEl == null) {
                if (otherEl != null) {
                    return false;
                }
            } else {
                if (!thisEl.equals(otherEl)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            T temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
