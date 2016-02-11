package com.faruzzy.dsaj.chpt3.SinglyLinkedListProblems;

import com.faruzzy.dsaj.chpt3.Node;
import com.faruzzy.dsaj.chpt3.SLinkedList;
import com.faruzzy.dsaj.utils.u;

public class Interview {
    /**
     * Write a function that takes as arguments two singly linked lists
     * and returns a singly linked list with nodes that exist in only one of the input linked lists.
     */
    public static <T extends Comparable> SLinkedList<T> unique(SLinkedList<T> a, SLinkedList<T> b) {
        SLinkedList<T> ret = new SLinkedList<T>();
        Node<T> currA = a.getFirst();
        boolean s = false;

        while (currA != null) {
            Node<T> tempA = null;
            if (currA != a.getFirst()) {
                tempA = new Node<T>(currA.getValue());
            }
            Node<T> currB = b.getFirst();
            Node<T> tempB = null;
            while (currB != null) {
                if (currA.getValue() == currB.getValue()) {
                    s = true;
                    if (tempB == null) {
                        Node<T> n = b.getFirst().getNext();
                        b.getFirst().setNext(null);
                        b.setFirst(n);
                        currB = n;
                    } else {
                        Node<T> next = currB.getNext();
                        currB.setNext(null);
                        tempB.setNext(next);
                        break;
                    }
                }
                tempB = new Node<T>(currB.getValue());
            }

            if (s) {
                s = false;
                if (tempA == null) {
                    Node<T> n = b.getFirst().getNext();
                    b.getFirst().setNext(null);
                    b.setFirst(n);
                    currA = n;
                } else {
                    Node<T> next = currA.getNext();
                    currA.setNext(null);
                    tempA.setNext(next);
                    continue;
                }
            }
            currA = currA.getNext();
        }

        b.getLast().setNext(a.getFirst());
        return b;
    }

    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<String>();
        list.addFirst("Robert");
        list.addFirst("Jarred");
        list.addFirst("Michael");
        list.addFirst("Jesse");

        SLinkedList<String> alist = new SLinkedList<String>();
        alist.addFirst("Jarred");
        alist.addFirst("Patrick");
        alist.addFirst("Junior");
        alist.addFirst("Oliver");

        SLinkedList<String> xlist = unique(list, alist);
        u.println(xlist.toString());

    }
}
