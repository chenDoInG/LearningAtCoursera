package com.chendoing.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {

    private class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for(ListNode node : lists){
            if(node!=null)
                queue.offer(node);
        }
        ListNode virtual = new ListNode(0), cursor = virtual, temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.next != null)
                queue.offer(temp.next);
            cursor.next = temp;
            cursor = cursor.next;
        }
        return virtual.next;
    }

    @Test
    public void mergeKLists() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node3.next = node4;
        ListNode[] lists = {node1,node3};
        System.out.println(mergeKLists(lists));
    }
}
