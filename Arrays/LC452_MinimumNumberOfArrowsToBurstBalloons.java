/*
 * LeetCode 452 - Minimum Number of Arrows to Burst Balloons
 *
 * Difficulty: Medium
 * Topic: Array, Greedy, Sorting
 *
 * Approach:
 * - Sort balloons by end coordinate (points[i][1]).
 * - Fire an arrow at the end coordinate of the first balloon; it bursts all overlapping balloons.
 * - If next balloon start > current arrow position, shoot a new arrow at its end coordinate.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */

import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int currentEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;
    }
}
