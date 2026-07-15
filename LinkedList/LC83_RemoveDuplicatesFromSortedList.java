/*
 * LeetCode 83 - Remove Duplicates from Sorted List
 *
 * Difficulty: Easy
 * Topic: Linked List
 *
 * Approach:
 * - Traverse the linked list.
 * - If the current node and next node have the same value,
 *   skip the duplicate node.
 * - Otherwise, move to the next node.
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

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}