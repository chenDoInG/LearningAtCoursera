package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{ val=" + val + ", next=" + next + '}';
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result, other;
        if (l1.val <= l2.val) {
            result = l1;
            other = l2;
        } else {
            result = l2;
            other = l1;
        }
        ListNode cursor = result;
        while (cursor.next != null) {
            ListNode tmp;
            if (cursor.next.val > other.val) {
                tmp = cursor.next;
                cursor.next = other;
                other = tmp;
            }
            cursor = cursor.next;
        }
        cursor.next = other;
        return result;
    }

    @Test
    public void mergeTwoLists() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node3.next = node4;
        System.out.println(mergeTwoLists(node1, node3));
    }
}

