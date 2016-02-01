package com.faruzzy.dsaj.chpt3;

/**
 * Created by faruzzy on 1/23/16.
 */
public class Node {
    private String element;
    private Node next;

    public Node(String s, Node n) {
        element = s;
        next = n;
    }

    public Node(String s) {
        element = s;
        next = null;
    }

    public String getElement() { return element; }

    public void setElement(String s) { element = s; }

    public Node getNext() { return next; }

    public void setNext(Node newNext) { next = newNext; }
}
