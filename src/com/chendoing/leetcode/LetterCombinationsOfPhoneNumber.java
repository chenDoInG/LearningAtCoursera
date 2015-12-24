package com.chendoing.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class LetterCombinationsOfPhoneNumber {

    private String[][] letters = {
            {},
            {},
            {"a", "c", "b"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return Collections.emptyList();

        List<String> result = new ArrayList<>();
        StringBuffer letterBeforeAllDigitVisited = new StringBuffer();

        dfs(digits, result, letterBeforeAllDigitVisited, 0);
        return result;
    }

    public void dfs(String digits, List<String> result, StringBuffer letterBeforeAllDigitVisited, int visitedIndex) {
        if (visitedIndex == digits.length())
            result.add(letterBeforeAllDigitVisited.toString());
        else {
            int digit = digits.charAt(visitedIndex) - '0';
            for (String letterAtEachDigit : letters[digit]) {
                letterBeforeAllDigitVisited.append(letterAtEachDigit);
                dfs(digits, result, letterBeforeAllDigitVisited, visitedIndex + 1);
                letterBeforeAllDigitVisited.deleteCharAt(letterBeforeAllDigitVisited.length() - 1);
            }
        }
    }

    @Test
    public void letterCombinations() {
        System.out.println(letterCombinations("333"));
    }
}
