package com.chendoing.leetcode;

import java.util.List;

/**
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a-b|.
 * Your task is to find the maximum distance.
 * <p>
 * Example 1:
 * Input:
 * [[1,2,3],
 * [4,5],
 * [1,2,3]]
 * Output: 4
 * Explanation:
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 * <p>
 * Note:
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 * The total number of the integers in all the m arrays will be in the range of [2, 10000].
 * The integers in the m arrays will be in the range of [-10000, 10000].
 */
public class MaximumDistanceInArrays {

    public static int maxDistance(List<List<Integer>> arrays) {
        int distance = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (List<Integer> array : arrays) {
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);
            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
            distance = Math.abs(min - max);
        }
        return distance;
    }
}
