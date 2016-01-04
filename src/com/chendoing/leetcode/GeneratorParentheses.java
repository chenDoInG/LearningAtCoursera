package com.chendoing.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GeneratorParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n <= 0)
            return ret;
        searchPath(n, n, "", ret);
        return ret;
    }

    private void searchPath(int left, int right, String path, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(String.valueOf(path));
            return;
        }
        if (left > right || left < 0) {
            return;
        }
        searchPath(left - 1, right, path + "(", result);
        searchPath(left, right - 1, path + ")", result);
    }

    @Test
    public void generateParenthesis() {
        long start = System.currentTimeMillis();
        System.out.println(generateParenthesis(14));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
