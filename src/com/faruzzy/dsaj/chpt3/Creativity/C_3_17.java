package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.u;

/**
 * C-3.17
 * Write a short recursive Java method that will rearrange an array
 * of int values so that all the even values appear before all the odd values.
 */
public class C_3_17 {
    public static void arrangeEvenBeforeOdd(int[] array, int start) {
        int len = array.length;
        if (start < len) {
            while(array[start] % 2 != 0) {
                if (len == start) return;

                if (array[len - 1] % 2 == 0) {
                    int temp = array[start];
                    array[start] = array[len - 1];
                    array[len - 1] = temp;
                } else {
                    len--;
                }
            }
            arrangeEvenBeforeOdd(array, ++start);
        }
    }

    public static void main(String[] args) {
        int[] array = { 9, 7, 5, 3, 2, 4, 6, 8, 10 };
        arrangeEvenBeforeOdd(array, 0);
        u.printArray(array);
    }
}
