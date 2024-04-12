package org.am.greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    private static final Map<Character, String> map = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return Collections.emptyList();
        return letterCombinations(digits, 0);
    }

    private List<String> letterCombinations(String digits, int start) {
        List<String> result = new LinkedList<>();
        String chars = map.get(digits.charAt(start));
        if (start == digits.length() - 1) {
            for (char c : chars.toCharArray())
                result.add(String.valueOf(c));
            return result;
        } else {
            List<String> intermediateResults = letterCombinations(digits, start + 1);
            for (char c : chars.toCharArray()) {
                for (String intermediateResult : intermediateResults)
                    result.add(String.valueOf(c).concat(intermediateResult));
            }
        }
        return result;
    }
}
