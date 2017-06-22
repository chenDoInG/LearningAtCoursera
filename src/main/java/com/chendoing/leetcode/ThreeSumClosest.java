package com.chendoing.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for (int index = 0; index < nums.length - 2; index++) {
            if (index == 0 || nums[index] != nums[index - 1]) {
                int low = index + 1, high = nums.length - 1;
                while (low < high) {
                    int diff = nums[index] + nums[low] + nums[high] - target;
                    if (diff == 0)
                        return target;
                    closest = Math.abs(diff) < Math.abs(closest) ? diff : closest;
                    if (diff < 0)
                        low++;
                    else high--;
                }
            }
        }
        return target+closest;
    }

    @Test
    public void threeSumClosest() {
        System.out.println(threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }
}
