/*
 * LeetCode 621 - Task Scheduler
 *
 * Difficulty: Medium
 * Topic: Array, Hash Table, Greedy, Sorting, Heap (Priority Queue), Counting
 *
 * Approach:
 * - Identify the task with the maximum frequency maxFreq.
 * - Count how many tasks share this maximum frequency (maxCount).
 * - Minimum time is bounded by (maxFreq - 1) * (n + 1) + maxCount or total tasks length.
 *
 * Time Complexity: O(m), where m is tasks length
 * Space Complexity: O(1) - fixed 26 alphabet frequencies
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int maxFreq = 0;

        for (char t : tasks) {
            counts[t - 'A']++;
            maxFreq = Math.max(maxFreq, counts[t - 'A']);
        }

        int maxCount = 0;
        for (int c : counts) {
            if (c == maxFreq) {
                maxCount++;
            }
        }

        int emptySlots = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, emptySlots);
    }
}
