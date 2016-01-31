package com.faruzzy.dsaj.utils;
import java.util.Random;

/**
 * Created by faruzzy on 1/28/16.
 * Utility Class created with the purpose of holding, functions that are mostly needed.
 */
public class Util {

    /**
     * Method wrapper of System.out.print
     * @param str String to print to the terminal
     */
    public static void print(String str) {
        System.out.print(str);
    }

    /**
     * Method wrapper of System.out.println
     */
    public static void println() {
        System.out.println();
    }

    /**
     * Method wrapper of System.out.println
     * @param str String to print to the terminal with a new line
     */
    public static void println(String str) {
        System.out.println(str);
    }

    /**
     * Print content of an array to the terminal
     * @param array the array which content is to be printed
     */
    public static void printArray(int[] array) {
        String s = "[ ";
        for (int i = 0; i < array.length; i++) {
            s += array[i] + " ";
        }
        s += "]";
        println(s);
    }

    /**
     * Get the index of a value in an array
     * @param array The array to search in
     * @param value The value to search the index of in the array
     * @param <T> Type of the array and the value
     * @return The Index of the value in the array or -1 if value not found in the array
     */
    public static <T> int indexOf(T[] array, T value) {
        int ret = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    /**
     * Randomly generate values for each index of an array
     * @param array The Array to generate the values for
     * @param maxValue The max randomized values
     * @return
     */
    public static int[] generateArrayValues(int[] array, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(maxValue);
        return array;
    }

    /**
     * Print the content of a multiple dimensional array
     * @param array The Array which content we want to display
     * @param <T> The type of the Array
     */
    public static <T> void printMultiDimensionalArray(T array[][]) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++)
                System.out.print(""+ array[i][j]);
            println();
        }
    }
}
