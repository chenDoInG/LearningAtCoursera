package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Created by chenDoInG on 15/8/21.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given a string, find the length of the longest substring without
     * repeating characters. For example, the longest substring without
     * repeating letters for "abcabcbb" is "abc", which the length is 3. For
     * "bbbbb" the longest substring is "b", with the length of 1.
     *
     * @param s
     * @return int
     * @author : chenDoInG
     * @date : 2015年8月14日
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int[] startIndex4substringStartAtEachcharact = new int[255];
        for (int i = 0; i < startIndex4substringStartAtEachcharact.length; i++) {
            startIndex4substringStartAtEachcharact[i] = -1;
        }
        int startIndex4CurrentSubstring = 0;
        int max = 0;
        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            if (startIndex4substringStartAtEachcharact[s.charAt(currentIndex)] >= startIndex4CurrentSubstring) {
                startIndex4CurrentSubstring = startIndex4substringStartAtEachcharact[s.charAt(currentIndex)] + 1;
            }
            startIndex4substringStartAtEachcharact[s.charAt(currentIndex)] = currentIndex;
            max = Math.max(max, currentIndex - startIndex4CurrentSubstring + 1);
        }
        return max;
    }

    @Test
    public void lengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("aa"));
    }
}
