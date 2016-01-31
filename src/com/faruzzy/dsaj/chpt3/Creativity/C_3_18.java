package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.Util;
/**
 * Created by faruzzy on 1/30/16.
 *
 * C-3.18:
 * Write a short recursive Java method that takes a character
 * string s and outputs its reverse. So for example, the reverse of "pots&pans" would be "snap&stop".
 */
public class C_3_18 {
    public static String reverseString(String s, int i, String newString) {
        if (i < 0) return newString;
        newString += s.charAt(i);
        return reverseString(s, --i, newString);
    }

    public static void main(String[] args) {
        String s = "pots&pans";
        Util.println(reverseString(s, s.length() - 1, ""));
    }
}
