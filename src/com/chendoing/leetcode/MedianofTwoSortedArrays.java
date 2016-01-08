package com.chendoing.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * @author : chenDoInG
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] num3 = new int[length];
        for (int i = 0; i < nums1.length; i++) {
            num3[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            num3[nums1.length + i] = nums2[i];
        }
        Arrays.sort(num3);

        if (num3.length % 2 == 0) {
            return ((double) (num3[length / 2 - 1] + num3[length / 2])) / 2;
        }
        return (double) num3[length / 2];
    }

    @Test
    public void findMedianSortedArrays4() {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
