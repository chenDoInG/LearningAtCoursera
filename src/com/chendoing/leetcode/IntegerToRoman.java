package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {

    private String[][] roman = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
    };
    private String[] unit = {"","元", "拾", "佰", "仟", "万"};
    private String[] number = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public String intToRoman(int num) {
        int digit = 0;
        String romman = "";
        while (num > 0) {
            int lastNuber = num % 10;
            romman = getRome(digit, lastNuber) + romman;
            num /= 10;
            digit++;
        }
        return romman.trim();
    }

    private String getRome(int digit, int number) {
        return roman[digit][number];
    }

    public String intToChinese(int num){
        int digit = 0;
        String chinese = "";
        return chinese;
    }
    @Test
    public void intToRoman() {
        System.out.println(intToRoman(0));
    }
}
