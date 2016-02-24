package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int first, int last, int target) {
        if (first > last)
            return -1;
        int mid = (first + last) / 2;
        if (target == nums[mid])
            return mid;
        if (nums[first] <= nums[mid]) {
            if (target >= nums[first] && target <= nums[mid]) {
                return search(nums, first, mid - 1, target);
            } else
                return search(nums, mid + 1, last, target);
        }
        if (nums[mid] <= nums[last]) {
            if (target >= nums[mid] && target <= nums[last]) {
                return search(nums, mid + 1, last, target);
            } else
                return search(nums, first, mid - 1, target);
        }
        return -1;
    }

    @Test
    public void search(){
        System.out.println(search(new int[]{5,1,3},3));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},11));
    }
}

