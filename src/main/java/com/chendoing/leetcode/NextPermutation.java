package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 4,3,2,1 → 1,3,2,4
 * 4,2,3,3 4 3 3 2 4 3 2 3
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums.length<2)
            return;
        int cursor = nums.length - 2;
        while (cursor >= 0 && nums[cursor] >= nums[cursor + 1])
            cursor--;
        if(cursor>=0){
            int indexOfNumSmallThanCursor = nums.length-1;
            while (nums[indexOfNumSmallThanCursor]<=nums[cursor])
                indexOfNumSmallThanCursor--;
            swap(nums,cursor,indexOfNumSmallThanCursor);

        }
        reverse(nums, cursor+1 , nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    @Test
    public void nextPermutation() {
        nextPermutation(new int[]{1,1});
    }
}
