/*
 * LeetCode 752 - Open the Lock
 *
 * Difficulty: Medium
 * Topic: Queue, BFS, String
 *
 * Approach:
 * - Treat each 4-digit combination as a graph state.
 * - Use BFS to find the minimum number of turns.
 * - For each state, generate 8 possible combinations by
 *   rotating each wheel forward or backward.
 * - Use a Set to track visited states and deadends.
 *
 * Time Complexity: O(10^4)
 * Space Complexity: O(10^4)
 */

import java.util.*;

class Solution {

    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int turns = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return turns;
                }

                for (int j = 0; j < 4; j++) {

                    char[] chars = current.toCharArray();

                    // Rotate forward
                    chars[j] = (char) ((chars[j] - '0' + 1) % 10);
                    String next = new String(chars);

                    if (!dead.contains(next) && visited.add(next)) {
                        queue.offer(next);
                    }

                    // Rotate backward
                    chars = current.toCharArray();
                    chars[j] = (char) ((chars[j] - '0' + 9) % 10);
                    next = new String(chars);

                    if (!dead.contains(next) && visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }

            turns++;
        }

        return -1;
    }
}