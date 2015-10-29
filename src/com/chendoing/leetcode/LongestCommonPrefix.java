package com.chendoing.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    //数组排序后，直接比较第一个后最后一个就可以拿到最长前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0)
            return "";
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        StringBuilder longestCommonPrefix = new StringBuilder();
        for (int index = 0; index < first.length; index++) {
            if (last.length > index && last[index] == first[index])
                longestCommonPrefix.append(last[index]);
            else
                break;
        }
        return longestCommonPrefix.toString();
    }

    @Test
    public void longestCommonPrefix() {

        System.out.print(longestCommonPrefix(new String[]{"aab", "abb","aaaaa"}));
    }
}
