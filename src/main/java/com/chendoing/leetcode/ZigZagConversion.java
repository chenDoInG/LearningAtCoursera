package com.chendoing.leetcode;

import org.junit.Test;

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
     */
    public String convert(String s, final int numRows) {
        StringBuilder sb = new StringBuilder();
        int deltaT = 2 * (numRows - 1);
        if(deltaT == 0)
            deltaT = 1;
        for(int rowIndex = 1, counter = 0; rowIndex <=numRows; rowIndex++, counter++)
        {
            int deltaC = 2 * (numRows-rowIndex);
            int index = counter;
            while (index < s.length())
            {
                sb.append(s.charAt(index));
                if(rowIndex != numRows && rowIndex != 1 && (index + deltaC) < s.length())
                {
                    sb.append(s.charAt(index + deltaC));
                }
                index += deltaT;
            }
        }
        return sb.toString();
    }

    @Test
    public void convert(){
        System.out.print(convert("PAYPALISHIRING",3));
    }
}
