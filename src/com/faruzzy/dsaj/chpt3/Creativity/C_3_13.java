package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.u;
import com.faruzzy.dsaj.chpt3.Node;
import com.faruzzy.dsaj.chpt3.SLinkedList;

/**
 * C-3.13
 * Describe a recursive algorithm that counts the number of nodes in a singly linked list.
 */
public class C_3_13 {

    public static int count(SLinkedList<String> list, Node<String> current, int count) {
        if (current == null) return count;
        current = current.getNext();
        return count(list, current, ++count);
    }

    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<String>();
        list.addFirst("Rajesh");
        list.addLast("Sheldon");
        list.addLast("Cooper");
        list.addFirst("Jeremy");
        u.print(count(list, list.getFirst(), 0) + "");
    }
}
