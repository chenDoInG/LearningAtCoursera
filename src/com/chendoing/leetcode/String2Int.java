package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Created by chenDoInG on 15/8/23.
 */
public class String2Int {

    public int myAtoi(String str) {
        str = str.trim();
        if ("".equals(str)) return 0;
        int result = 0;
        boolean positive = true;
        int length = 0;
        if (str.charAt(0) == '-') positive = false;
        else if (str.charAt(0) == '+' || Character.isDigit(str.charAt(0))) {
            positive = true;
        } else return 0;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && i > 0) break;
            if (Character.isDigit(str.charAt(i))) {
                length++;
                int temp = str.charAt(i)-'0';
                temp = positive?temp:-temp;
                if(positive&&(length>10||(result * 10 >= Integer.MAX_VALUE - temp)))
                    return  Integer.MAX_VALUE;
                if(!positive&&(length>10||(result * 10 <= Integer.MIN_VALUE - temp))){
                    return  Integer.MIN_VALUE;
                }
                result = result * 10 +temp;
            }
        }
        return result;
    }

    @Test
    public void myAtoi() {
        System.out.println(myAtoi("-+1"));
    }
}
