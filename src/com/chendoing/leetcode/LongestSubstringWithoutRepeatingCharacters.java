package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Given a string, find the length of the longest substring without
 * repeating characters. For example, the longest substring without
 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
 * "bbbbb" the longest substring is "b", with the length of 1.
 *
 * @author : chenDoInG
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int[] startIndex4substringStartAtEachCharacter = new int[255];
        for (int i = 0; i < startIndex4substringStartAtEachCharacter.length; i++) {
            startIndex4substringStartAtEachCharacter[i] = -1;
        }
        int startIndex4CurrentSubstring = 0;
        int max = 0;
        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            if (startIndex4substringStartAtEachCharacter[s.charAt(currentIndex)] >= startIndex4CurrentSubstring) {
                startIndex4CurrentSubstring = startIndex4substringStartAtEachCharacter[s.charAt(currentIndex)] + 1;
            }
            startIndex4substringStartAtEachCharacter[s.charAt(currentIndex)] = currentIndex;
            max = Math.max(max, currentIndex - startIndex4CurrentSubstring + 1);
        }
        return max;
    }

    @Test
    public void lengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("aa"));
    }
}
