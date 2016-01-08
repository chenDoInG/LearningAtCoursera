package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty())
            return 0;

        int m = haystack.length();
        int n = needle.length();
        for(int i = 0 ; i<=(m-n);i++){
            if(haystack.substring(i,i+n).equals(needle))
                return i;
        }
        return -1;
    }

    @Test
    public void strStr() {
        System.out.println(strStr("a", "a"));
    }
}
