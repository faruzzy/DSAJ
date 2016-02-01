package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.Util;

/**
 * Created by faruzzy on 1/31/16.
 * C-3.16
 * Describe a recursive algorithm that will check if an array A of integers contains
 * an integer A[i] that is the sum of two integers that appear earlier in A,
 * that is, such that A[i] = A[j] +A[k] for j,k > i.
 */
public class C_3_16 {

    public static boolean checkItemForSum(int[] array, int start, int length, boolean success) {
        if (start == length) return success;
        for (int j = 0; j < start; j++) {
            for (int k = j + 1; k < start; k++) {
                if (array[j] + array[k] == array[start]) {
                    return true;
                }
            }
        }
        return checkItemForSum(array, ++start, length, success);
    }


    public static void main(String[] args) {
        //int[] array = { 2, 4, 3, 7, 10, 20, 8 }; // should be true
        int[] array = { 2, 4, 8, 11, 9, 1, 0 }; // should be false
        boolean result = checkItemForSum(array, 0, array.length, false);
        if (result) {
            Util.println("True");
        } else {
            Util.println("False");

        }
    }
}
