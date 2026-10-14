/*
 * LeetCode 49 - Group Anagrams
 *
 * Difficulty: Medium
 * Topic: Arrays, Hash Table, String, Sorting
 *
 * Approach:
 * - Use a HashMap where the key is the sorted character array of a word and the value is the list of anagrams.
 * - Iterate through each string, sort its characters to form the canonical key, and append to the map.
 * - Return the map values.
 *
 * Time Complexity: O(n * k log k), where n is number of strings and k is maximum length of a string
 * Space Complexity: O(n * k)
 */

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
