package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Remove Duplicates from Sorted Array
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int cursor = 1, length = 0;
        while (cursor < nums.length) {
            if (nums[cursor] != nums[cursor - 1])
                nums[++length] = nums[cursor];
            cursor++;
        }
        return length + 1;
    }

    @Test
    public void removeDuplicates() {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3}));
    }
}
