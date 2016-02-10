package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.u;
/**
 * C-3.18:
 * Write a short recursive Java method that takes a character
 * string s and outputs its reverse. So for example, the reverse of "pots&pans" would be "snap&stop".
 */
public class C_3_18 {
    public static String reverseString(String s, int i) {
        if (i < 0) return s.charAt(s.length() - 1) + "";
        return s.charAt(i) + reverseString(s, --i);
    }

    public static String reverse(String s) {
        if (s.length() == 1) return s;
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        String s = "pots&pans";
        u.println(reverseString(s, s.length() - 1));
        u.println(reverse(s));
    }
}
