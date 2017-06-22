package com.chendoing.leetcode;

import org.junit.Test;

/**
 * You are given an array of positive and negative integers.
 * If a number n at an index is positive, then move forward n steps.
 * Conversely, if it's negative (-n), move backward n steps. Assume the first element of the array is forward next to the last element,
 * and the last element is backward next to the first element. Determine if there is a loop in this array.
 * A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.
 * <p>
 * Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.
 * <p>
 * Example 2: Given the array [-1, 2], there is no loop.
 * <p>
 * Note: The given array is guaranteed to contain no element "0".
 * <p>
 * Can you do it in O(n) time complexity and O(1) space complexity?
 */
public class CircularArrayLoop {


    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (find(nums, nums[i] > 0, i, i, 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean find(int[] nums, boolean direction, int front, int connect, int count) {
        if (count >= nums.length)
            return false;
        int step = nums[front];
        if (step > 0 && direction || step < 0 && !direction) {
            nums[front] = connect;
            int next = front + step >= nums.length ? front + step - nums.length : front + step < 0 ? nums.length + (front + step) : front + step;
            return next != front && (nums[next] == connect|| find(nums, direction, next, connect, count + 1));
        }
        return false;
    }

    @Test
    public void check() {
        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(circularArrayLoop(new int[]{-1, 2}));
        System.out.println(circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
        System.out.println(circularArrayLoop(new int[]{-1, -2, -3, -4, -5}));
        System.out.println(circularArrayLoop(new int[]{1, 2, 3, 4, 5}));
    }
}
