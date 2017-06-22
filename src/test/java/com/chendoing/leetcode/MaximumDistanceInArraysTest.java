package com.chendoing.leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class MaximumDistanceInArraysTest {

    @Test
    public void maxDistance() throws Exception {
        ArrayList<Integer> array1 = Lists.newArrayList(1, 2, 3);
        ArrayList<Integer> array2 = Lists.newArrayList(4, 5);
        List<List<Integer>> arrays = Lists.newArrayList(array1, array2, array1);
        assertThat(MaximumDistanceInArrays.maxDistance(arrays)).isEqualTo(4);
    }
}