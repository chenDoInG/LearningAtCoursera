package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    private int search(int[] nums, int first, int last, int target) {
        while (first <= last) {
            int mid = (first + last) / 2;
            if (nums[mid] == target)
                return mid;
            if(mid==nums.length-1&&nums[mid]<target)
                return mid+1;
            if(mid==0&&nums[mid]>target)
                return 0;
            if (nums[mid]<target&&target<nums[mid+1])
                return mid+1;
            if (target > nums[mid])
                first = mid + 1;
            else last = mid - 1;
        }
        return -1;
    }

    @Test
    public void searchInsert(){
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsert(new int[]{1,3,5,6},7));
        System.out.println(searchInsert(new int[]{1,3,5,6},0));
        System.out.println(searchInsert(new int[]{1,3},2));
        System.out.println(4/3);
    }
}
