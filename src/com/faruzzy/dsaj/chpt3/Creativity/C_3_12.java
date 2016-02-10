package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.u;

/**
 * C-3.12
 * Describe a recursive method for converting a string of digits into the integer it represents.
 * For example, "13531" represents the integer 13,531.
 */
public class C_3_12 {
    public static int convertStringToInt(String value, int i, int length) {
        int k = 1;
        int s = 0;
        while (s++ < length - 1)
            k *= 10;
        if (length == 1)
            return Character.getNumericValue(value.charAt(value.length() -1));
        return (Character.getNumericValue(value.charAt(i)) * k) + convertStringToInt(value, ++i, --length);
    }

    public static void main(String[] args) {
        String v = "13531";
        u.print(convertStringToInt(v, 0, v.length()) + "");
    }
}
