package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.Util;

/**
 * Created by faruzzy on 2/1/16.
 * C-3.12
 * Describe a recursive method for converting a string of digits into the integer it represents.
 * For example, "13531" represents the integer 13,531.
 */
public class C_3_12 {
    public static int convertStringToInt(String value, int start, int length, int sum) {
        int s = 0;
        int k = 1;
        while (s++ < length - 1) {
            k *= 10;
        }
        if (length == 1)
            return sum + value.charAt(start);
        sum += Character.getNumericValue(value.charAt(start)) * k;
        return convertStringToInt(value, ++start, --length, sum);
    }

    public static void main(String[] args) {
        String v = "13531";
        Util.print(convertStringToInt(v, 0, v.length(), 0) + "");
    }
}
