package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.u;

/**
 * C-3.17
 * Write a short recursive Java method that will rearrange an array
 * of int values so that all the even values appear before all the odd values.
 */
public class C_3_17 {
    public static void arrangeEvenBeforeOdd(int[] array, int start, int end) {
        boolean allOdds = false;
        int e = end - 1;
        if (start < end) {
            while(array[start] % 2 != 0) {
                if (e == start) {
                    allOdds = true;
                    break;
                }

                if (array[e] % 2 == 0) {
                    int temp = array[start];
                    array[start] = array[e];
                    array[e] = temp;
                } else {
                    e--;
                }
            }
            if (allOdds) return;
            arrangeEvenBeforeOdd(array, ++start, --end);
        }
    }

    public static void main(String[] args) {
        int[] array = { 9, 7, 5, 3, 2, 4, 6, 8, 10 };
        arrangeEvenBeforeOdd(array, 0, array.length);
        u.printArray(array);
    }
}
