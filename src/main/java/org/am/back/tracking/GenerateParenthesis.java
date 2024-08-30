package org.am.back.tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">...</a>
 */
public class GenerateParenthesis {

    List<String> parenthesis = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, "");
        return parenthesis;
    }

    private void backtrack(int n, int open, int close, String currParenthesis) {
        if (open == n && close == n)
            parenthesis.add(currParenthesis);

        // There are 2 possibilities
        if (open >= close && open < n) {// valid condition to branch of with "("
            currParenthesis += '(';
            backtrack(n, open + 1, close, currParenthesis);
            currParenthesis = currParenthesis.substring(0, currParenthesis.length() - 1);
        }
        if (open > close) {
            currParenthesis += ')';
            backtrack(n, open, close + 1, currParenthesis);
            currParenthesis = currParenthesis.substring(0, currParenthesis.length() - 1);
        }
    }
}
