/*
 * LeetCode 876 - Middle of the Linked List
 *
 * Difficulty: Easy
 * Topic: Linked List
 *
 * Approach:
 * - Use two pointers:
 *   - slow moves one step.
 *   - fast moves two steps.
 * - When fast reaches the end,
 *   slow will be at the middle node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}