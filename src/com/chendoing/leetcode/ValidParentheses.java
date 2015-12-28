package com.chendoing.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    enum Parentheses {

        Error('#') {
            @Override
            boolean endWith(char right) {
                return false;
            }
        },
        Small('(') {
            @Override
            boolean endWith(char right) {
                return ')' == right;
            }
        },
        Mid('[') {
            @Override
            boolean endWith(char right) {
                return ']' == right;
            }
        },
        Large('{') {
            @Override
            boolean endWith(char right) {
                return '}' == right;
            }
        };

        private char s;

        Parentheses(char s) {
            this.s = s;
        }

        abstract boolean endWith(char right);

    }

    private Parentheses parentheses(char left) {
        for (Parentheses parentheses : Parentheses.values()) {
            if (parentheses.s == left)
                return parentheses;
        }
        return Parentheses.Error;
    }

    private boolean validate(String s, int right) {
        return s.isEmpty() || right < s.length() && (parentheses(s.charAt(0)).endWith(s.charAt(right))
                && validate(s.substring(1, right), 1) && validate(s.substring(right + 1, s.length()), 1)
                || validate(s, right + 2));
    }

    public boolean isValidByDp(String s) {

        if (s == null || s.isEmpty() || s.length() % 2 != 0)
            return false;

        return validate(s, 1);
    }

    private boolean isValidByStack(String s) {
        Stack<Character> open = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    open.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (open.isEmpty()) return false;
                    if (pairs.get(open.pop()) != ch) return false;
                    break;
                default:
            }
        }
        return open.isEmpty();
    }

    @Test
    public void isValidByDp() {
        String s = "(";
        System.out.println(isValidByDp(s));
        System.out.println(isValidByStack(s));
    }
}
