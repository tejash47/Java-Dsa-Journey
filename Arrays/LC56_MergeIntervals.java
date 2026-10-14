/*
 * LeetCode 56 - Merge Intervals
 *
 * Difficulty: Medium
 * Topic: Arrays, Sorting, Intervals
 *
 * Approach:
 * - Sort intervals by their start points.
 * - Iterate through sorted intervals, maintaining a current interval.
 * - If the next interval overlaps with current (next.start <= current.end), merge them by updating current.end.
 * - Otherwise, push current to the result list and move to the next interval.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                current = intervals[i];
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
