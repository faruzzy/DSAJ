package com.faruzzy.dsaj.chpt3;
import com.faruzzy.dsaj.utils.u;

public class Recursion {
    public static int recursiveFactorial(int n) {
        if (n == 0) return 1;
        return n * recursiveFactorial(n - 1);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = n; i >= 1; i--)
            result *= i;
        return result;
    }

    public static int power(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        return x * power(x, n - 1);
    }

    public static int rabbitFib(int n) {
        if (n == 1 || n == 2) return 2;
        return rabbitFib(n - 1) + rabbitFib(n - 2);
    }

    public static int sumArray(int[] array, int n) {
        if (n == 1) return array[0];
        return array[n - 1] + sumArray(array, n - 1);
    }

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            int k = array.length - i - 1;
            array[i] = array[k];
            array[k] = temp;
        }
    }

    public static void recursiveReverseArray(int[] array, int i, int j) {
        if (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            recursiveReverseArray(array, i + 1, j - 1);
        }
    }

    public static void iterativeReverseArray(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int temp = array[i];
            array[i]  = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static int iterativeFibonacci(int n) {
        if (n == 1 || n == 2) return 1;

        // starting at 3rd fibonacci
        int prev = 1;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = i + prev;
            prev = res;
        }
        return res;
    }

    private static void printArray(int[] array) {
        String s = "[ ";
        for (int elem : array)
            s += elem + " ";
        s += "]";
        System.out.println(s);
    }

    public static void main(String[] args) {
        u.println("8th fibonacci number is: " + fib(8));
        u.println("8th iterative fibonacci number is: " + iterativeFibonacci(4));
        u.println("Rabbit 7th yeah number is: " + rabbitFib(7));
        System.out.println(recursiveFactorial(5));
        System.out.println(factorial(5));
        System.out.println(sumArray(new int[] {1, 2, 3, 4, 5}, 5));
        int[] arr = new int[] {3, 5, 1, 4, 9, 10};
        int[] array = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        reverseArray(arr);
        recursiveReverseArray(array, 0, array.length - 1);
        printArray(arr);
        printArray(array);
        iterativeReverseArray(array);
        printArray(array);

        u.print(power(2, 4) + "");
    }

}
