package com.chendoing.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length <= 0)
            return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        for (int index = 0; index < nums.length - 2; index++) {

            if (index == 0 || nums[index] != nums[index - 1]) {
                towSum(nums, -nums[index], index + 1, nums.length - 1, results);
            }
        }
        return results;
    }

    private void towSum(int[] nums, int target, int beginIndex, int endIndex, List<List<Integer>> results) {
        while (beginIndex < endIndex) {
            int first = nums[beginIndex];
            int second = nums[endIndex];
            if (first + second == target) {
                List<Integer> result = new ArrayList<>();
                result.add(-target);
                result.add(first);
                result.add(second);
                results.add(result);
                beginIndex++;
                while (beginIndex < endIndex && nums[beginIndex] == nums[beginIndex - 1])
                    beginIndex++;
            } else if (first + second < target)
                beginIndex++;
            else
                endIndex--;
        }
    }

    @Test
    public void threeSum() {
        System.out.print(threeSum(new int[]{-3, 1, 2, 3}));
    }
}
