/*
 * LeetCode 451 - Sort Characters By Frequency
 *
 * Difficulty: Medium
 * Topic: Hash Table, String, Sorting, Heap (Priority Queue), Bucket Sort, Counting
 *
 * Approach:
 * - Count character frequencies using HashMap or frequency array.
 * - Use bucket sort where index represents frequency and stores characters of that count.
 * - Build result string by reading buckets from highest count to lowest.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
