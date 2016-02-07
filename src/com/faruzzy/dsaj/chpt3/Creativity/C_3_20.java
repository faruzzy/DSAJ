package com.faruzzy.dsaj.chpt3.Creativity;
import com.faruzzy.dsaj.utils.u;

/**
 * Created by faruzzy on 1/31/16.
 * C-3.20
 * Use recursion to write a Java method for determining if a string s has more vowels than consonants.
 */
public class C_3_20 {
    private static Character[] vowels = { 'a', 'e', 'i', 'o', 'u' };

    public static boolean hasMoreVowelsThanConsonants(String s, int i, int vcounter, int ccounter) {
        if (i < 0) return vcounter > ccounter;
        if (u.indexOf(vowels, s.charAt(i)) != -1) {
            ++vcounter;
        } else {
           ++ccounter;
        }
        return hasMoreVowelsThanConsonants(s, --i, vcounter, ccounter);
    }

    public static void main(String[] args) {
        //String str = "history";
        String str = "auopmousie";
        boolean result = hasMoreVowelsThanConsonants(str, str.length() - 1, 0, 0);
        if (result) {
            u.println(str + " has more vowels than consonants");
        } else {
            u.println(str + " has more consonants than vowels");
        }
    }

}
