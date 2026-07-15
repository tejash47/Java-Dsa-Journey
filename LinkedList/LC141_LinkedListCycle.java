/*
 * LeetCode 141 - Linked List Cycle
 *
 * Difficulty: Easy
 * Topic: Linked List
 *
 * Approach:
 * - Use Floyd's Cycle Detection Algorithm.
 * - Maintain two pointers:
 *   - slow moves one step.
 *   - fast moves two steps.
 * - If they meet, a cycle exists.
 * - If fast reaches null, there is no cycle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}