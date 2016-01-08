package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length < 1)
            return 0;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                nums[start] = nums[end];
                end--;
            } else
                start++;
        }
        return end + 1;
    }

    @Test
    public void removeElement() {
        System.out.println(removeElement(new int[]{1,}, 1));
    }
}
