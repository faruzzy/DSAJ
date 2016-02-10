package com.faruzzy.dsaj.chpt3.Reinforcement;
import com.faruzzy.dsaj.utils.u;

import java.util.Random;

/**
 * R-3.10
 * Describe a recursive algorithm for finding the maximum element in an array A of n elements.
 * What is your running time and space usage?
 */
public class R_3_10 {
    public static int findMaximum(int[] array, int i, int max) {
        if (i == array.length)
           return max;

        if (array[i] > max) {
            max = array[i];
        }
        return findMaximum(array, i + 1, max);

    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++)
            array[i] = random.nextInt(20);
        u.printArray(array);
        u.println(findMaximum(array, 0, 0) + "");
    }
}
