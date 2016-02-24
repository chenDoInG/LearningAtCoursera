package com.chendoing.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int pos = search(nums, 0, nums.length - 1, target);
        if (pos == -1)
            return result;
        int temp = pos, first = pos, second = pos;
        while (temp != -1) {
            first = temp;
            temp = search(nums, 0, temp - 1, target);
        }
        temp = pos;
        while (temp != -1) {
            second = temp;
            temp = search(nums, temp + 1, nums.length - 1, target);
        }
        result[0] = first;
        result[1] = second;
        return result;
    }

    public int search(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return -1;
    }

    @Test
    public void searchRange() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
    }
}
