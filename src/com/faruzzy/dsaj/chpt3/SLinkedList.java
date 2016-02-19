package com.faruzzy.dsaj.chpt3;
import com.faruzzy.dsaj.utils.u;

public class SLinkedList<T extends Comparable> {
    private Node<T> head;
    private Node<T> tail;
    public int length;

    public SLinkedList() {
        head = tail = null;
        length = 0;
    }

    public Node<T> getFirst() {
        if (isEmpty())
            throw new IllegalStateException("List is Empty");
        return head;
    }

    public void setFirst(Node<T> node) {
        head = node;
    }

    public void setLast(Node<T> node) {
        tail = node;
    }

    public Node<T> getLast() {
        if (isEmpty())
            throw new IllegalStateException("List is Empty");
        return tail;
    }

    public void addFirst(final T s) {
        Node<T> n = new Node<T>(s);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
        length++;
    }


    public void removeFirst() {
        if (isEmpty()) {
            u.println("LinkedList is empty");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node<T> temp = head;
            head = head.getNext();
            temp.setNext(null);
        }
        length--;
    }

    public void removeAt(int index) {
        if (index == 0) {
            if (head == tail) {
                clear();
            } else if (isEmpty()) {
                System.out.println("LinkedList is empty");
            } else {
                removeFirst();
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
        length--;
    }

    public void clear() {
        head = tail = null;
        length = 0;
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
            length--;
        }
    }

    public void addLast(final T v) {
        Node<T> n = new Node<T>(v);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
        length++;
    }

    public int getLength() { return length; }

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

    public boolean isEmpty() { return (length == 0); }

    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<String>();
        list.addFirst("2");
        list.removeFirst();
        System.out.println(list.toString());
        System.out.println("Length: " + list.getLength());

        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        System.out.println(list.toString());
        System.out.println("Length: " + list.getLength());

        list.addLast("10");
        list.addLast("12");
        list.removeAt(2);

        System.out.println(list.toString());
        System.out.println("Length: " + list.getLength());

        list.removeFirst();
        System.out.println(list.toString());
        System.out.println("Length: " + list.getLength());

        list.removeFromBack();
        System.out.println(list.toString());
        System.out.println("Length: " + list.getLength());

        list.clear();
        System.out.println(list.toString());
        System.out.println("Length: " + list.getLength());
    }
}
