package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Created by chenDoInG on 15/8/23.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0)
            return  false;
        int reserve = 0;
        int temp = x;
        while(temp!=0){
            reserve *=10;
            reserve += temp%10;
            temp /= 10;
        }
        return reserve==x;
    }

    @Test
    public void is(){
        System.out.println(isPalindrome(12));
    }
}
