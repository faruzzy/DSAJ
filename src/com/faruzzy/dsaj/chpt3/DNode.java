package com.faruzzy.dsaj.chpt3;

public class DNode<T> {
    private T value;
    private DNode<T> prev, next;

    public DNode(T e, DNode<T> p, DNode<T> n) {
        value = e;
        prev = p;
        next = n;
    }

    public DNode(T e) {
        this(e, null, null);
    }

    public T getValue() { return value; }

    public void setValue(T elem) { value = elem; }

    public DNode<T> getNext() { return next; }

    public void setNext(DNode<T> n) { next = n; }

    public void setPrev(DNode<T> p) { prev = p; }

    public DNode<T> getPrev() { return prev; }
}
