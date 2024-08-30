package org.am.back.tracking;

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

    private final List<String> letterCombinations = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return letterCombinations;
        backtrack(digits, 0, "");
        return letterCombinations;
    }

    private void backtrack(String digits, int index, String currLetterCombination) {
        if (index == digits.length()) {
            letterCombinations.add(currLetterCombination);
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            currLetterCombination += String.valueOf(letters.charAt(i));
            backtrack(digits, index + 1, currLetterCombination);
            currLetterCombination = currLetterCombination.substring(0, currLetterCombination.length() - 1);
        }
    }
}
