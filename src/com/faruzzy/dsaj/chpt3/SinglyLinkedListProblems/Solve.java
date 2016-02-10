package com.faruzzy.dsaj.chpt3.SinglyLinkedListProblems;

import com.faruzzy.dsaj.chpt3.Node;
import com.faruzzy.dsaj.chpt3.SLinkedList;
import com.faruzzy.dsaj.utils.u;

/**
 * Linked list exercises from: cslibrary.stanford.edu/105/LinkedListProblems.pdf
 */
public class Solve {
    /**
     * A function that counts the number of times a given int occurs in a list.
     */
    public static <T extends Comparable> int count(SLinkedList<T> list, T n) {
        Node<T> current = list.getFirst();
        int count = 0;
        while (current != null) {
            if (current.getValue() == n) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    /**
     * function that takes a linked list and an integer index and returns the data
     * value stored in the node at that index position.
     */
    public static <T extends Comparable> T getNth(SLinkedList<T> list, int n) {
        int count = 0;
        if (count == n)
            return list.getFirst().getValue();
        count++;
        Node<T> current = list.getFirst().getNext();
        while (count != n) {
            current = current.getNext();
            count++;
        }
        return current.getValue();
    }

    /**
     * A function DeleteList() that takes a list, deallocates all of its memory and sets its
     * head pointer to NULL (the empty list).
     */
    public static <T extends Comparable> void insertNth(SLinkedList<T> list, int n, T value) {
        if (n > list.length)
            throw new IllegalStateException("Inaccessible index");
        if (list.isEmpty()) {
            list.addFirst(value);
        } else {
            int count = 0;
            Node<T> current = list.getFirst();
            while (count != n - 1) {
                current = current.getNext();
                count++;
            }
            Node<T> newNode = new Node<T>(value);
            Node<T> next = current.getNext();
            current.setNext(newNode);
            newNode.setNext(next);
        }
        list.length++;
    }

    /**
     * A function that is the inverse of Push(). Pop() takes a non-empty list, deletes
     * the head node, and returns the head node's data
     */
    public static <T extends Comparable> T pop(SLinkedList<T> list) {
        T value = list.getFirst().getValue();
        list.removeFirst();
        return value;
    }

    public static <T extends Comparable> void deleteList(SLinkedList<T> list) {
        list.getFirst().setNext(null);
    }

    /**
     * A function which given a list that is sorted in increasing order, and a
     * single node, inserts the node into the correct sorted position in the list.
     */
    public static <T extends Comparable> void sortedInsert(SLinkedList<T> list, Node<T> node) {
        Node<T> curr = list.getFirst();

        while (curr != null) {
            Node<T> prev = curr;
            curr = curr.getNext();
            if (prev.getValue().compareTo(node.getValue()) < 0 && node.getValue().compareTo(curr.getValue()) < 0) {
                prev.setNext(node);
                node.setNext(curr);
                break;
            }
        }
    }

    public static <T extends Comparable> void insertSort(SLinkedList<T> list) {
        Node<T> current = list.getFirst();
        while (current != null) {
            Node<T> temp = new Node<T>(current.getValue());
            sortedInsert(list, temp);

            Node<T> oldCurrent = current;
            current = current.getNext();
            oldCurrent.setNext(null);
        }
    }

    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<String>();
        list.addFirst("Junior");
        list.addFirst("Patrick");
        list.addFirst("Marie");
        list.addFirst("Patrick");
        list.addFirst("Robert");
        list.addFirst("Rajesh");
        list.addLast("Patrick");

        System.out.println(list);
        insertSort(list);
        u.println("List after insert sort: " + list);
        System.out.println("Number of instances for Patrick in list: " + count(list, "Patrick"));
        System.out.println("Get 5th element: " + getNth(list, 5));
        System.out.println(pop(list));
        System.out.println(list);
        insertNth(list, 4, "Zidane");
        System.out.println("List after insert of zidane: " + list);
        sortedInsert(list, new Node<String>("Xena"));
        System.out.println("After sorted insert: " + list);
    }
}


