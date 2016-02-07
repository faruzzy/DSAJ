package com.faruzzy.dsaj.chpt3.Reinforcement;

import com.faruzzy.dsaj.chpt3.DLinkedList;
import com.faruzzy.dsaj.chpt3.DNode;
import com.faruzzy.dsaj.utils.u;

/**
 * Created by faruzzy on 1/30/16.
 * R-3.14
 * Write a short Java method to count the number of nodes in a circularly linked list.
 */
public class R_3_14 {
    private static int count(DLinkedList<String> list) {
        int count = 0;
        DNode<String> current = list.header.getNext();
        while (!current.equals(list.trailer)) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public static void main(String[] args) {
        DLinkedList<String> list = new DLinkedList<String>();
        list.addFirst("Roland");
        list.addFirst("Patrick");
        list.addFirst("Junior");
        list.addFirst("Rachel");
        list.addLast("Amundala");
        u.println("Count: " + count(list));
    }
}
