package com.faruzzy.dsaj.chpt3.Reinforcement;
import com.faruzzy.dsaj.utils.Util;
import java.util.Random;

/**
 * Created by faruzzy on 1/28/16.
 * R-3.2
 * Describe a way to use recursion to add all the elements in a n × n (two dimensional) array of integers.
 */
public class R_3_2 {
    private static int[][] array;
    private Random random;

    public R_3_2() {
        array = new int[6][6];
        random = new Random();
        generateValues();
        Util.printMultiDimensionalArray(array);
    }

    public int addAllArrayElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += binarySum(array[i], 0, array.length - 1);
        return sum;
    }

    private static int binarySum(int[] array, int low, int high) {
        if (low > high) return 0;
        if (low == high) return array[low];
        int mid = (low + high) / 2;
        return binarySum(array, low, mid) + binarySum(array, mid + 1, high);
    }

    private void generateValues() {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
    }

    public static void main(String[] args) {
        R_3_2 obj = new R_3_2();

        //testing binarySum
        //int[] arr =  { 1, 2, 3, 4, 5, 6, 7 };
        //System.out.println(binarySum(arr, 0, arr.length - 1));
        Util.println("Total: " + obj.addAllArrayElements(array));
    }
}
