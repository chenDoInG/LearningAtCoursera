package com.chendoing.leetcode;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class PredictTheWinnerTest {

    @Test
    public void predictTheWinner() throws Exception {
        assertThat(PredictTheWinner.predictTheWinner(new int[]{1, 5, 233, 7})).isTrue();
    }
}