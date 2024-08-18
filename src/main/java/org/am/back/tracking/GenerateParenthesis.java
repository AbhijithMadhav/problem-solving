package org.am.back.tracking;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">...</a>
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        return gen(n, 0, 0);
    }

    private List<String> gen(int n, int open, int close) {
        // Reached the leaf node. Return empty string so that valid parenthesis can be constructed
        // while unwinding(traversing up the tree)
        if (open == n && close == n)
            return List.of("");

        List<String> parenthesis = new LinkedList<>();
        if (open >= close && open < n) // valid condition to branch of with "("
            parenthesis.addAll(
                    gen(n, open + 1, close).stream().map(str -> "(" + str).toList()
            );
        if (open > close) // valid condition to branch of with ")"
            parenthesis.addAll(
                    gen(n, open, close + 1).stream().map(str ->  ")" + str).toList()
            );
        return parenthesis;
    }
}
