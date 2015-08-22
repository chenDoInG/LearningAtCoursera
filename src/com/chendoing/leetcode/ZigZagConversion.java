package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Created by chenDoInG on 15/8/21.
 */
public class ZigZagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

     P   A   H   N
     A P L S I I G
     Y   I   R
     And then read line by line: "PAHNAPLSIIGYIR"
     Write the code that will take a string and make this conversion given a number of rows:

     string convert(string text, int nRows);
     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, final int numRows) {
        StringBuilder sb = new StringBuilder();
        int delta = 2 * (numRows - 1);
        if(delta == 0)
            delta = 1;
        for(int i = numRows - 1, counter = 0; i >= 0; i--, counter++)
        {
            int delta1 = 2 * i;
            int index = counter;
            while (index < s.length())
            {
                sb.append(s.charAt(index));
                if(i != numRows-1 && i != 0 && (index + delta1) < s.length())
                {
                    sb.append(s.charAt(index + delta1));
                }
                index += delta;
            }
        }
        return sb.toString();
    }

    @Test
    public void convert(){
        System.out.print(convert("PAYPALISHIRING",13));
    }
}
