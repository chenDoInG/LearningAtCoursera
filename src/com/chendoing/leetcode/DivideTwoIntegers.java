package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {

    /**
     * use bit operation
     * >> move left equals divide 2
     * << move right equals multi 2
     * example:
     * with division: 100 / 3 = 33
     * without division:
     * 3 * 2^5 = 96  (100 > 96)
     * 100 - 96 = 4
     * 3 * 2^0 = 3 (4 > 3)
     * 4 - 3 = 1 (1 < 3 end)
     * result = 2^5 + 2^0 = 33
     *
     * @param dividend the num to b divide
     * @param divisor  the divide num
     * @return result
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long divide = Math.abs((long) dividend);
        long dis = Math.abs((long) divisor);
        int result = 0;
        while (divide >= dis) {
            int count = 0;
            while (divide >= dis << count) {
                count++;
            }
            //div<<count is larger than divide so must - 1
            count--;
            result += 1 << count;
            divide -= dis << count;
        }
        return dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? result : -result;
    }

    @Test
    public void divide() {
        System.out.print(divide(100, 3));
    }
}
