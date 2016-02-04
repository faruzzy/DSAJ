package com.faruzzy.dsaj.chpt3;
import com.faruzzy.dsaj.utils.Util;

/**
 * Created by faruzzy on 1/23/16.
 */
public class SLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    private int size;

    public SLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void insertAtFront(final T s) {
        Node<T> n = new Node<T>(s);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
        size++;
    }


    public void removeAtFront() {
        if (isEmpty()) {
            Util.println("LinkedList is empty");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node<T> temp = head;
            head = head.getNext();
            temp.setNext(null);
        }
        size--;
    }

    public void removeAt(int index) {
        if (index == 0) {
            if (head == tail) {
                clear();
            } else if (isEmpty()) {
                System.out.println("LinkedList is empty");
            } else {
                removeAtFront();
            }
        } else {
            int c = 0;
            Node current = head;
            while (current != null && c < index) {
                current = current.getNext();
                c++;
            }
            if (current != null) {
                Node third = current.getNext().getNext();
                current.setNext(third);
            }
        }
        size--;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public void removeFromBack() {
        if (isEmpty()) {
            System.out.println("LinkedList is empty");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.getNext() != tail)
               current = current.getNext();
            current.setNext(null);
            size--;
        }
    }

    public void insertAtBack(final T v) {
        Node<T> n = new Node<T>(v);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    public int getSize() { return size; }

    @Override
    public String toString() {
        String s = "[ ";
        Node current = head;
        while (current != null) {
            s += current.getValue() + " ";
            current = current.getNext();
        }
        s += "]";
        return s;
    }

    private boolean isEmpty() { return size == 0; }

    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<String>();
        list.insertAtFront("2");
        list.removeAtFront();
        System.out.println(list.toString());
        System.out.println("Size: " + list.getSize());

        list.insertAtFront("3");
        list.insertAtFront("4");
        list.insertAtFront("5");

        System.out.println(list.toString());
        System.out.println("Size: " + list.getSize());

        list.insertAtBack("10");
        list.insertAtBack("12");
        list.removeAt(2);

        System.out.println(list.toString());
        System.out.println("Size: " + list.getSize());

        list.removeAtFront();
        System.out.println(list.toString());
        System.out.println("Size: " + list.getSize());

        list.removeFromBack();
        System.out.println(list.toString());
        System.out.println("Size: " + list.getSize());

        list.clear();
        System.out.println(list.toString());
        System.out.println("Size: " + list.getSize());


    }
}
