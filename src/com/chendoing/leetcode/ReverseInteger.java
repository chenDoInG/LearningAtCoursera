package com.chendoing.leetcode;

import org.junit.Test;

public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        while (x!=0){
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10)
                return  0;
            result = result*10 + x%10;
            x= x /10;
        }
        return  result;
    }

    @Test
    public void reverse(){
        System.out.println(reverse(-100000003));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(-2,31));
    }
}
