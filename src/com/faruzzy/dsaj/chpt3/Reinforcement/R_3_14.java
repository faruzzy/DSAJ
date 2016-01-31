package com.faruzzy.dsaj.chpt3.Reinforcement;

import com.faruzzy.dsaj.chpt3.DNodeString;
import com.faruzzy.dsaj.chpt3.DLinkedListString;
import com.faruzzy.dsaj.utils.Util;

/**
 * Created by faruzzy on 1/30/16.
 * R-3.14
 * Write a short Java method to count the number of nodes in a circularly linked list.
 */
public class R_3_14 {
    private static int count(DLinkedListString list) {
        int count = 0;
        DNodeString current = list.header.getNext();
        while (current != list.trailer) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public static void main(String[] args) {
        DLinkedListString list = new DLinkedListString();
        list.addFirst("Roland");
        list.addFirst("Patrick");
        list.addFirst("Junior");
        list.addFirst("Rachel");
        list.addLast("Amundala");
        Util.println("Count: " + count(list));
    }
}
