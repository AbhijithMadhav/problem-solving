package org.am.two.pointer;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 */
public class PalindromicSubStrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int r = i;
            count += getPalindromeCount(s, i, r);
            r = i + 1;
            count += getPalindromeCount(s, i, r);
        }
        return count;
    }

    private static int getPalindromeCount(String s, int l, int r) {
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            r++;
            l--;
        }
        return count;
    }
}
