package com.chendoing.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenDoInG on 15/8/30.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean ans[][] = new boolean[ss.length + 1][pp.length + 1];

        ans[0][0] = true; // empty string empty pattern
        for (int i = 0; i <= ss.length; i++) {
            //default ans[i][0] = false; for all i > 0 //  non-empty string, empty pattern
            for (int j = 1; j <= pp.length; j++) {
                if (pp[j - 1] != '*') {
                    ans[i][j] = i > 0 && matches(ss[i - 1], pp[j - 1]) && ans[i - 1][j - 1];
                } else {
                    ans[i][j] = j >= 2 && (
                            ans[i][j - 2] ||
                                    (i > 0 && matches(ss[i - 1], pp[j - 1 - 1]) && ans[i - 1][j])
                    );
                }
            }
        }
        return ans[ss.length][pp.length];
    }

    boolean matches(char c, char p) {
        if (p == '.') return true;
        else return c == p;
    }

    @Test
    public void isMatch() {
        Assert.assertTrue(isMatch("aaa", "ab*ac*a"));
    }

}
