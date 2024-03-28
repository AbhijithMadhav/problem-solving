package org.am.two.pointer;

/**
 * Two points to note
 * 1. Checking for palindrome from middle is more easy
 * 2. Look out for even and odd length palindromes
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        var res = "";
        for (int i = 0; i < s.length(); i++) {
            // odd length palindromes
            res = checkForLongerPalindrome(s, i, i, res);

            // even length palindrome
            res = checkForLongerPalindrome(s, i, i+1, res);
        }
        return res;
    }

    private static String checkForLongerPalindrome(String s, int l, int r, String res) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ) {
            if (r - l + 1 > res.length())
                res = s.substring(l, r + 1);
            l--;
            r++;
        }
        return res;
    }
}
