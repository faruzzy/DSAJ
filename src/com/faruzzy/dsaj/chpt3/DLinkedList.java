package com.faruzzy.dsaj.chpt3;

/**
 * Created by faruzzy on 1/25/16.
 */
public class DLinkedList<T extends Comparable> {
    private int size;
    private DNode<T> header;
    private DNode<T> trailer;

    public DLinkedList() {
        size = 0;
        header = new DNode(null, null, null);
        trailer = new DNode(null, header, null);
        header.setNext(trailer);
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public DNode getFirst() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return header.getNext();
    }

    public DNode getLast() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return trailer.getPrev();
    }

    public DNode getPrev(final DNode node) throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return node.getPrev();
    }

    public DNode getNext(final DNode node) throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return node.getNext();
    }

    public void addBefore(final DNode v, final DNode z) {
        DNode u = v.getPrev();
        u.setNext(z);
        z.setPrev(u);
        z.setNext(v);
        v.setPrev(z);
        size++;
    }

    public void sort() {
        DNode current = header.getNext();
        while (current != trailer) {
            DNode next = current.getNext();
            while (next != header) {
                if (current.getElement().compareTo(next.getElement()) == 1) {
                    DNode temp = next;
                    this.remove(next);
                    this.addBefore(current, temp);
                    next = temp;
                }
            }
        }
    }

    public void addAfter(final DNode v, final DNode z) {
        DNode w = v.getNext();
        v.setNext(z);
        z.setPrev(v);
        z.setNext(w);
        w.setPrev(z);
        size++;
    }

    public void addFirst(final DNode v) {
        addAfter(header, v);
    }

    public void addLast(final DNode v) {
        addBefore(trailer, v);
    }

    public void remove(final DNode v) {
        DNode current = header.getNext();
        while (current != v) {
            current = current.getNext();
        }

        DNode u = current.getPrev();
        DNode w = current.getNext();
        u.setNext(w);
        w.setPrev(u);
        v.setNext(null);
        v.setPrev(null);
    }

    public boolean hasPrev(final DNode v) {
        return v.getPrev() != header;
    }

    public boolean hasNext(final DNode v) {
        return v.getNext() != trailer;
    }

    @Override
    public String toString() {
        String s = "[ ";
        DNode current = header.getNext();
        while (current != trailer) {
            s += current.getElement();
            current = current.getNext();
            if (current != trailer) {
                s += ", ";
            }
        }
        s += " ]";
        return s;
    }

    public static void main(String[] args) {
        DLinkedList<String> list = new DLinkedList<String>();
        list.addFirst(new DNode("Roland"));
        list.addFirst(new DNode("Junior"));
        list.addFirst(new DNode("Marie-Pierre"));
        list.addLast(new DNode("Newton"));
        DNode ninja = new DNode("Ninja");
        list.addLast(ninja);

        System.out.println(list.toString());
        list.sort();
        System.out.println(list.toString());
        //list.remove(ninja);
        //System.out.println(list.toString());
    }
}
