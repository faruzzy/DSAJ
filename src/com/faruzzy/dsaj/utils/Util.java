package com.faruzzy.dsaj.utils;
import java.util.Random;

/**
 * Created by faruzzy on 1/28/16.
 */
public class Util {

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void printArray(int[] array) {
        String s = "[ ";
        for (int i = 0; i < array.length; i++) {
            s += array[i] + " ";
        }
        s += "]";
        println(s);
    }

    public static int[] generateArrayValues(int[] array, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(maxValue);
        return array;
    }

    public static void printMultiDimensionalArray(int array[][]) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++)
                System.out.printf("%d ", array[i][j]);
            println();
        }
    }
}
