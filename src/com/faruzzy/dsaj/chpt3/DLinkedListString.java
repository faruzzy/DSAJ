package com.faruzzy.dsaj.chpt3;
import com.faruzzy.dsaj.utils.Util;

/**
 * Created by faruzzy on 1/26/16.
 */
public class DLinkedListString {
    public DNodeString header, trailer;
    private int size;

    public DLinkedListString() {
        header = new DNodeString(null, null, null);
        trailer = new DNodeString(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

    private boolean isEmpty() { return size == 0; }

    public void addFirst(final DNodeString node) {
        addAfter(header, node);
        size++;
    }

    public void addFirst(final String str) {
        DNodeString newNode = new DNodeString(str);
        addAfter(header, newNode);
        size++;
    }

    public void addLast(final DNodeString node) {
        addBefore(trailer, node);
        size++;
    }

    public void addLast(final String str) {
        DNodeString newNode = new DNodeString(str);
        addBefore(trailer, newNode);
        size++;
    }

    public void addAfter(final DNodeString v, final DNodeString z) {
        DNodeString w = v.getNext();
        v.setNext(z);
        z.setPrev(v);
        z.setNext(w);
        w.setPrev(z);
        size++;
    }

    public void addBefore(final DNodeString v, final DNodeString z) {
        DNodeString prevNode = v.getPrev();
        prevNode.setNext(z);
        z.setPrev(prevNode);
        z.setNext(v);
        v.setPrev(z);
        size++;
    }

    public void remove(final DNodeString w) throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        DNodeString current = header.getNext();
        while(current != w) {
            current = current.getNext();
        }

        DNodeString prevNode = current.getPrev();
        DNodeString nextNode = current.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        current.setNext(null);
        current.setPrev(null);
        size--;
    }

    public void removeFirst() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        DNodeString firstNode = header.getNext();
        DNodeString nextNode = firstNode.getNext();
        remove(firstNode);
        header.setNext(nextNode);
        nextNode.setPrev(header);
        size--;
    }

    public void removeLast() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        DNodeString last = trailer.getPrev();
        DNodeString beforeLast = last.getNext();
        remove(last);
        trailer.setPrev(beforeLast);
        beforeLast.setNext(trailer);
        size--;
    }

    @Override
    public String toString() {
        String s = "[ ";
        DNodeString current = header.getNext();

        while(current != trailer) {
            s += current.getValue();
            current = current.getNext();
            if (current != trailer) {
                s += ", ";
            }
        }
        s += " ]";
        return s;
    }

    public void sort() {
        DNodeString current = header.getNext();
        while (current != trailer) {
            while (current.getPrev() != header && current.getPrev().getValue().compareTo(current.getValue()) > 0) {
                DNodeString prev = current.getPrev();
                remove(current);
                addBefore(prev, current);
            }
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        DLinkedListString list = new DLinkedListString();
        list.addFirst("Roland");
        list.addFirst("Patrick");
        list.addFirst("Junior");
        list.addFirst("Rachel");
        list.addLast("Amundala");
        DNodeString zidane = new DNodeString("Zinedine");
        list.addFirst(zidane);
        System.out.println(list.toString());
        System.out.println("Sorting .. ");
        list.sort();
        System.out.println(list.toString());
        /*
        System.out.println(list);
        list.removeFirst();
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        */
    }
}
