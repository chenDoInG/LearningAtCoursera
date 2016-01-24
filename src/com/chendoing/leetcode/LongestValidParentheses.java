package com.chendoing.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        if (s == null || s.length() < 2)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    max = Math.max(max, i - (stack.isEmpty() ? left : stack.peek()));
                } else {
                    left = i;
                }
            }

        }
        return max;
    }

    private int dfs(String s, int start, int depth, int max) {
        if (start == s.length())
            return max;
        if (s.charAt(start) == '(') {
            max = dfs(s, start + 1, depth + 1, max);
        }
        if (s.charAt(start) == ')') {
            if (depth != 0 && start == s.length() - 1)
                return max;
            if (depth == 0) {
                max = Math.max(max, dfs(s, start + 1, 0, 0));
            } else {
                max = dfs(s, start + 1, depth - 1, max + 2);
            }
        }

        return max;
    }

    @Test
    public void longestValidParentheses() {
        System.out.println(longestValidParentheses(")()(())"));
        System.out.println(dfs(")()(())",0,0,0));
    }
}
