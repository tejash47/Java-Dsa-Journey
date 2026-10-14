/*
 * LeetCode 692 - Top K Frequent Words
 *
 * Difficulty: Medium
 * Topic: Hash Table, String, Trie, Sorting, Heap (Priority Queue), Bucket Sort, Counting
 *
 * Approach:
 * - Count word frequencies with HashMap.
 * - Use a min-heap of size k: ordered by lowest frequency first, and reverse lexicographical if frequencies tie.
 * - Collect words from heap and reverse to produce descending frequency order.
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String w : words) {
            countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            int f1 = countMap.get(w1);
            int f2 = countMap.get(w2);
            if (f1 != f2) return Integer.compare(f1, f2);
            return w2.compareTo(w1);
        });

        for (String w : countMap.keySet()) {
            pq.offer(w);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);

        return result;
    }
}
