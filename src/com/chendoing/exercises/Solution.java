package com.chendoing.exercises;

import java.util.Arrays;

import org.junit.Test;

public class Solution {

    /**
     * Given a string, find the length of the longest substring without
     * repeating characters. For example, the longest substring without
     * repeating letters for "abcabcbb" is "abc", which the length is 3. For
     * "bbbbb" the longest substring is "b", with the length of 1.
     * 
     * @author : chenDoInG
     * @date : 2015年8月14日
     * @param s
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int[] startIndex4substringStartAtEachcharact = new int[255];
        int startIndex4CurrentSubstring = 0;
        int max = 0;
        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            if (startIndex4substringStartAtEachcharact[s.charAt(currentIndex)] > startIndex4CurrentSubstring) {
                startIndex4CurrentSubstring = startIndex4substringStartAtEachcharact[s.charAt(currentIndex)] + 1;
            }
            startIndex4substringStartAtEachcharact[s.charAt(currentIndex)] = currentIndex;
            max = Math.max(max, currentIndex - startIndex4CurrentSubstring + 1);
        }
        return max;
    }

    @Test
    public void lengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("c"));
    }

    /**
     * Given an array of integers, find two numbers such that they add up to a
     * specific target number.
     * 
     * The function twoSum should return indices of the two numbers such that
     * they add up to the target, where index1 must be less than index2. Please
     * note that your returned answers (both index1 and index2) are not
     * zero-based.
     * 
     * You may assume that each input would have exactly one solution.
     * 
     * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
     * 
     * @author : chenDoInG
     * @date : 2015年8月14日
     * @param nums
     * @param target
     * @return int[]
     */
    public int[] towSum(int[] nums, int target) {
        int n = nums.length;
        Number[] number = new Number[n];
        for (int i = 0; i < n; i++) {
            number[i] = new Number(i + 1, nums[i]);
        }
        Arrays.sort(number);
        int begin = 0;
        int end = n - 1;
        int[] result = new int[2];
        while (begin < end) {
            if (number[begin].getNumber() + number[end].getNumber() < target) {
                begin++;
            } else if (number[begin].getNumber() + number[end].getNumber() > target) {
                end--;
            } else {
                if (number[begin].getIndex() > number[end].getIndex()) {
                    result[0] = number[end].getIndex();
                    result[1] = number[begin].getIndex();
                } else {
                    result[1] = number[end].getIndex();
                    result[0] = number[begin].getIndex();
                }
                break;
            }
        }
        return result;
    }

    public class ListNode {

        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * You are given two linked lists representing two non-negative numbers. The
     * digits are stored in reverse order and each of their nodes contain a
     * single digit. Add the two numbers and return it as a linked list.
     * 
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
     * 
     * @author : chenDoInG
     * @date : 2015年8月14日
     * @param l1
     * @param l2
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }

        if (carry == 1)
            p3.next = new ListNode(1);

        return newHead.next;
    }

    @Test
    public void test2() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    @Test
    public void test1() {
        int[] nums = { -1, -2, -3, -4, -5 };
        for (int re : towSum(nums, -8)) {
            System.out.println(re);
        }
        ;
    }
}

class Number implements Comparable<Number> {

    private int index;
    private int number;

    public Number(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Number that) {
        return this.number - that.number;
    }
}
