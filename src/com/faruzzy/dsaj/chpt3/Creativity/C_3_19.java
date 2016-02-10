package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.u;
/**
 * C-3.19:
 * Write a short recursive Java method that determines if a string s is a palindrome,
 * that is, it is equal to its reverse. For example, "racecar" and "gohangasalamiimalasagnahog" are palindromes.
 */
public class C_3_19 {
    public static boolean isPalindrome(String s, int i, int j, boolean b) {
        if (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                b = true;
                return isPalindrome(s, ++i, --j, b);
            } else {
                return false;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        String str = "gohangasalamiimalasagnahog";
        //String str = "racecar";
        //String str = "roland";
        if(isPalindrome(str, 0, str.length() - 1, false)) {
            u.println("Is Palindrome");
        } else {
            u.println("Is not a Palindrome");
        }
    }
}
