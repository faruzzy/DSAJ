package com.faruzzy.dsaj.chpt3;

/**
 * Created by faruzzy on 1/23/16.
 */
public class DNode<T extends Comparable> {
    private T element;
    private DNode<T> prev, next;

    public DNode(T e, DNode p, DNode n) {
        element = e;
        prev = p;
        next = n;
    }

    public DNode(T e) {
        this(e, null, null);
    }

    public T getElement() { return element; }

    public void setElement(T elem) { element = elem; }

    public DNode getNext() { return next;}

    public void setNext(DNode n) { next = n; }

    public void setPrev(DNode p) { prev = p; }

    public DNode getPrev() { return prev; }
}
