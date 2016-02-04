package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.Util;
import com.faruzzy.dsaj.chpt3.Node;
import com.faruzzy.dsaj.chpt3.SLinkedList;

/**
 * Created by faruzzy on 2/1/16.
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
        list.insertAtFront("Rajesh");
        list.insertAtBack("Sheldon");
        list.insertAtBack("Cooper");
        list.insertAtFront("Jeremy");
        Util.print(count(list, list.head, 0) + "");
    }
}
