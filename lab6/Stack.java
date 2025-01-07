package lab6;

public class Stack<T> {
    private T[] data;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void push(T element) {
        if (size < capacity) {
            data[size++] = element;
        } else {
            System.out.println("Стек переполнен");
        }
    }

    public T pop() {
        if (size > 0) {
            T element = data[--size];
            data[size] = null;
            return element;
        }
        System.out.println("Стек пуст");
        return null;
    }

    public T peek() {
        if (size > 0) {
            return data[size - 1];
        }
        System.out.println("Стек пуст");
        return null;
    }
}
