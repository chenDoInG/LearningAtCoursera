package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        char prev = 'A';
        int sum = 0;
        for (char ch : s.toCharArray()) {
            if (a[ch - 'A'] > a[prev - 'A']) {
                //we had plus it，so minus twice
                sum -= 2 * a[prev - 'A'];
            }
            sum += a[ch - 'A'];
            prev = ch;
        }
        return sum;
    }

    @Test
    public void romanToInt() {
        System.out.print(romanToInt("IMM"));
    }
}
