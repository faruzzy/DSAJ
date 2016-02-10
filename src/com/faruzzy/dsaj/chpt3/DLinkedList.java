package com.faruzzy.dsaj.chpt3;

public class DLinkedList<T extends Comparable> {
    private int size;
    public DNode<T> header;
    public DNode<T> trailer;

    public DLinkedList() {
        size = 0;
        header = new DNode<T>(null, null, null);
        trailer = new DNode<T>(null, header, null);
        header.setNext(trailer);
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public DNode<T> getFirst() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return header.getNext();
    }

    public DNode<T> getLast() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return trailer.getPrev();
    }

    public DNode<T> getPrev(final DNode<T> node) throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return node.getPrev();
    }

    public DNode<T> getNext(final DNode<T> node) throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return node.getNext();
    }

    public void addBefore(final DNode<T> v, final DNode<T> z) {
        DNode<T> u = v.getPrev();
        u.setNext(z);
        z.setPrev(u);
        z.setNext(v);
        v.setPrev(z);
        size++;
    }

    public void sort() {
        DNode<T> current = header.getNext();
        while (current != trailer) {
            DNode<T> next = current.getNext();
            while (next != header) {
                if (current.getValue().compareTo(next.getValue()) == 1) {
                    DNode<T> temp = next;
                    this.remove(next);
                    this.addBefore(current, temp);
                    next = temp;
                }
            }
        }
    }

    public void addAfter(final DNode<T> v, final DNode<T> z) {
        DNode<T> w = v.getNext();
        v.setNext(z);
        z.setPrev(v);
        z.setNext(w);
        w.setPrev(z);
        size++;
    }

    public void addFirst(final T v) {
        DNode<T> node = new DNode<T>(v);
        addAfter(header, node);
    }

    public void addLast(final T v) {
        DNode<T> node = new DNode<T>(v);
        addBefore(trailer, node);
    }

    public void remove(final DNode<T> v) {
        DNode<T> current = header.getNext();
        while (current != v) {
            current = current.getNext();
        }

        DNode<T> u = current.getPrev();
        DNode<T> w = current.getNext();
        u.setNext(w);
        w.setPrev(u);
        v.setNext(null);
        v.setPrev(null);
    }

    public boolean hasPrev(final DNode<T> v) {
        return v.getPrev() != header;
    }

    public boolean hasNext(final DNode<T> v) {
        return v.getNext() != trailer;
    }

    @Override
    public String toString() {
        String s = "[ ";
        DNode<T> current = header.getNext();
        while (current != trailer) {
            s += current.getValue();
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
        list.addFirst("Roland");
        list.addFirst("Junior");
        list.addFirst("Marie-Pierre");
        list.addLast("Newton");
        String ninja = "Ninja";
        list.addLast(ninja);

        System.out.println(list.toString());
        list.sort();
        System.out.println(list.toString());
        //list.remove(ninja);
        //System.out.println(list.toString());
    }
}
