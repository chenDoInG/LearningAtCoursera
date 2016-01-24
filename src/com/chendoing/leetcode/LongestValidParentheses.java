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

    /**
     * 使用matched数组来记录已经匹配的长度,
     * 计算下一个右括号')'时,寻找的左括号'('的位置left=right-1-matched[right-1],
     * 如果左括号'('的位置小于0计算结束,
     * 如果左括号'('左边位置left-1大于左边界的话,match[right]+=match[left-1]
     * s:       ) ( ) ( ) )
     * index:   0 1 2 3 4 5
     * matched: 0 0 2 0 4 0
     */
    public int longestValidParenthesesByDp(String s) {
        int n = s.length(), max = 0;
        int[] matched = new int[n];
        for (int right = 1; right < n; right++) {
            if (s.charAt(right) == ')') {
                int left = right - 1 - matched[right - 1];
                if (left >= 0 && s.charAt(left) == '(') {
                    matched[right] = matched[right - 1] + 2;
                    if (left - 1 > 0)
                        matched[right] += matched[left - 1];
                }
            }
            max = max <= matched[right] ? matched[right] : max;
        }
        return max;
    }

    @Test
    public void longestValidParentheses() {
        System.out.println(longestValidParentheses(")()(())))"));
        System.out.println(longestValidParenthesesByDp("(()))()()"));
    }
}
