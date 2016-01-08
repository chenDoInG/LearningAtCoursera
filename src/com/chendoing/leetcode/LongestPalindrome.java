package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Given a string S, find the longest palindromic substring in S. You may
 * assume that the maximum length of S is 1000, and there exists one unique
 * longest palindromic substring.
 *
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        int n = s.length();
        int len = 2 * n + 1;
        int[] radius4EachCharacter = new int[len];
        char[] filledStr = fillStringBySign(s.toCharArray());
        int point4LongestPalindrome = 0, end4LongestPalindrome = -1, maxRadius = -1;
        for (int i = 0; i < len; i++) {
            if (end4LongestPalindrome > i) {
                radius4EachCharacter[i] = Math.min(radius4EachCharacter[2 * point4LongestPalindrome - i], end4LongestPalindrome - i);
            } else {
                radius4EachCharacter[i] = 1;
            }
            while (i - radius4EachCharacter[i] >= 0 && i + radius4EachCharacter[i] < len && filledStr[i - radius4EachCharacter[i]] == filledStr[i + radius4EachCharacter[i]]) {
                radius4EachCharacter[i]++;
            }
            if (radius4EachCharacter[i] > maxRadius) {
                end4LongestPalindrome = i + radius4EachCharacter[i] - 1;
                point4LongestPalindrome = i;
                maxRadius = radius4EachCharacter[i];
            }
        }
        char[] result = new char[maxRadius-1];
        int j = 0;
        for (int i = point4LongestPalindrome - maxRadius + 1; i < point4LongestPalindrome + maxRadius; i++) {
            if (filledStr[i] != '#') {
                result[j] = filledStr[i];
                j++;
            }
        }
        return String.valueOf(result);
    }

    private char[] fillStringBySign(char[] s) {
        char[] str = new char[2 * s.length + 1];
        str[0] = '#';
        for (int i = 0; i < s.length; i++) {
            str[2 * i + 1] = s[i];
            str[2 * i + 2] = '#';
        }
        return str;
    }


    @Test
    public void longestPalindrome() {
        System.out.println(longestPalindrome("aabaas"));
    }
}
