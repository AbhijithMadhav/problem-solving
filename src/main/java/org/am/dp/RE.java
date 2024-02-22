package org.am.dp;

public class RE {

    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length()][p.length()];
        return isMatch(s, 0, p, 0, cache);
    }

    private boolean isMatch(String s, int i, String p, int j, Boolean[][] cache) {

        if (i >= s.length() && j >= p.length())
            return true;

        if (j >= p.length())
            return false;

        if (i < s.length() && cache[i][j] != null)
            return cache[i][j];

        // i might be > s.length
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean result = (match && isMatch(s, i + 1, p, j, cache))  // Consider the option of matching s[i] with *
                    || isMatch(s, i, p, j + 2, cache); // Consider the option of not matching s[i] with *
            if (i < s.length())
                cache[i][j] = result;
            return result;
        }
        if (match) {
            cache[i][j] = isMatch(s, i + 1, p, j + 1, cache);
            return cache[i][j];
        }

        return false;
    }
}
