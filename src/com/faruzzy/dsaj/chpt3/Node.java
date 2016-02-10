package com.faruzzy.dsaj.chpt3;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T v, Node<T> n) {
        value = v;
        next = n;
    }

    public Node(T v) {
        value = v;
        next = null;
    }

    public T getValue() { return value; }

    public void setValue(T v) { value = v; }

    public Node<T> getNext() { return next; }

    public void setNext(Node n) { next = n; }

    @Override
    public String toString() {
        return value.toString();
    }
}
