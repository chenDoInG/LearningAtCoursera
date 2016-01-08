package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }

    /**
     * remove n node from the end of list
     * a example: n = 2
     * fast and slow
     * |
     * -1 -> 1 -> 2 -> 3 -> 4 -> 5
     * when n = 0
     * slow      fast
     * |         |
     * -1 ->1 -> 2 -> 3 -> 4 -> 5
     * fast go to end of list
     *               slow      fast
     *                |         |
     * -1 ->1 -> 2 -> 3 -> 4 -> 5
     * slow.next is the node to remove
     * @param head the head of list
     * @param n the index from the end of list
     * @return the head of removed list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0)
            return head;
        //增加一个虚拟的顶点,防止删除的是head时出错
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            if (n-- <= 0)
                slow = slow.next;
        }

        //n总是有效的,所以slow.next永远不会null,不用增加slow.next的判断
        slow.next = slow.next.next;

        return dummy.next;
    }

    @Test
    public void removeNthFromEnd() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(removeNthFromEnd(node1, 1));
    }
}
