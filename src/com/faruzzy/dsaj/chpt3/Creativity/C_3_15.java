package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.Util;

/**
 * Created by faruzzy on 2/1/16.
 *
 * C-3.15
 * Write a short recursive Java method that finds the minimum and
 * maximum values in an array of int values without using any loops.
 */
public class C_3_15 {
    public static int[] findMinAndMax(int[] array, int currentIndex, int end, int min, int max) {
        if (currentIndex == end) {
            int[] arr = {min, max};
            return arr;
        }
        if (array[currentIndex] < min)
            min = array[currentIndex];
        if (array[currentIndex] > max)
            max = array[currentIndex];
        return findMinAndMax(array, ++currentIndex, end, min, max);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Util.printArray( findMinAndMax(array, 0, array.length, array[0], array[0]) );
    }
}
