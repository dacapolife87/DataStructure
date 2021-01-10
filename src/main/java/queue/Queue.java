package queue;

import stack.Stack;

import java.util.NoSuchElementException;

public class Queue<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if (last != null) {
            last.next = t;
        }

        last = t;
        if(first == null) {
            first = last;
        }
        size++;
    }

    public T remove() {
        if(first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if(first == null) {
            last = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}
