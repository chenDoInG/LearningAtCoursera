package com.chendoing.exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQ {

    @Test
    public void count() {
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>((current, next) -> {
            if (current < next) {
                return 1;
            }
            if (current == next) {
                return 0;
            }
            return -1;
        });
        Integer[] s = { 99, 66, 80, 40, 56, 22, 63, 31, 38, 36 };
        priorityQueue.addAll(Arrays.asList(s));
        priorityQueue.add(88);
        priorityQueue.add(81);
        priorityQueue.add(37);
        System.out.println();
        priorityQueue.forEach(pq -> {
            System.out.print(pq + " ");
        });
    }

    @Test
    public void count1() {
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>((current, next) -> {
            if (current < next) {
                return 1;
            }
            if (current == next) {
                return 0;
            }
            return -1;
        });
        Integer[] s = { 81, 68, 57, 55, 64, 34, 37, 41, 50, 17 };
        priorityQueue.addAll(Arrays.asList(s));
        priorityQueue.remove();
        priorityQueue.remove();
        priorityQueue.remove();
        priorityQueue.forEach(pq -> {
            System.out.print(pq + " ");
        });
    }
}
