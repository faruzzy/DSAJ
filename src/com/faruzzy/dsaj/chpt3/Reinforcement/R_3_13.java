package com.faruzzy.dsaj.chpt3.Reinforcement;
import com.faruzzy.dsaj.utils.Util;
import java.util.Random;

/**
 * Created by faruzzy on 1/30/16.
 * R-3.13
 * Write a short Java method that repeatedly selects and
 * removes a random entry from an array until the array holds no more entries.
 */
public class R_3_13 {

    public static void clearArray(int[] array) {
        Random random = new Random();
        while(!isEmpty(array)) {
            int index = random.nextInt(array.length);
            if (array[index] != -1)
                array[index] = -1;
        }
    }

    private static boolean isEmpty(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] != -1) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[20];
        array = Util.generateArrayValues(array, 40);
        Util.printArray(array);
        clearArray(array);
        Util.printArray(array);
    }
}
