/*
 * LeetCode 506 - Relative Ranks
 *
 * Difficulty: Easy
 * Topic: Array, Sorting, Heap (Priority Queue)
 *
 * Approach:
 * - Pair each score with its original index, then sort pairs in descending order of score.
 * - Assign "Gold Medal", "Silver Medal", "Bronze Medal" to top 3, and numeric ranks (4, 5, ...) to rest.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        String[] result = new String[n];
        for (int rank = 0; rank < n; rank++) {
            int origIdx = pair[rank][1];
            if (rank == 0) result[origIdx] = "Gold Medal";
            else if (rank == 1) result[origIdx] = "Silver Medal";
            else if (rank == 2) result[origIdx] = "Bronze Medal";
            else result[origIdx] = String.valueOf(rank + 1);
        }

        return result;
    }
}
