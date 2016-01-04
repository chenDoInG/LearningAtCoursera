package com.chendoing.leetcode;

import org.junit.Test;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "-> " + next;
        }
    }

    /**
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * |    |              |
     * pre  last           tail
     * after call pre = reverse(pre, next)
     * <p>
     * 0->3->2->1 -> 4->5->6
     * |        |    |
     * pre      last tail
     *
     * @param pre
     * @param tail
     * @return the reversed list's last node, which is the precedence of parameter next
     */
    private ListNode reverse(ListNode pre, ListNode tail) {
        ListNode last = pre.next;//where first will be doomed "last"
        ListNode cursor = last.next;
        while (cursor != tail) {
            last.next = cursor.next;
            cursor.next = pre.next;
            pre.next = cursor;
            cursor = last.next;
        }
        return last;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void reverseKGroup() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(reverseKGroup(node1, 7));
    }
}
