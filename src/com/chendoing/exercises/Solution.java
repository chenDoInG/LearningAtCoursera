package com.chendoing.exercises;

import java.util.Arrays;

import org.junit.Test;

public class Solution {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }
 
            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
 
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
 
        if(carry==1) 
            p3.next=new ListNode(1);
 
        return newHead.next;
    }

    @Test
    public void test2(){
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode l3 = addTwoNumbers(l1, l2);
        while(l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
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
