/*
 * LeetCode 435 - Non-overlapping Intervals
 *
 * Difficulty: Medium
 * Topic: Array, Dynamic Programming, Greedy, Sorting
 *
 * Approach:
 * - Greedy interval scheduling: sort intervals by their end times.
 * - Always keep the interval that ends earliest to leave maximal space for subsequent intervals.
 * - Count overlaps when interval.start < previous.end.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
