/*
 * LeetCode 787 - Cheapest Flights Within K Stops
 *
 * Difficulty: Medium
 * Topic: Graph, Shortest Path, Bellman-Ford
 *
 * Approach:
 * - Use Bellman-Ford style relaxation.
 * - At most k + 1 edges can be used because k stops
 *   means at most k + 1 flights.
 * - Use a temporary copy of the distances array for each
 *   iteration so that a single iteration represents exactly
 *   one additional flight.
 *
 * Time Complexity: O(k * E)
 * Space Complexity: O(V)
 *
 * where:
 * V = number of cities
 * E = number of flights
 */

import java.util.Arrays;

class Solution {

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // At most k + 1 flights
        for (int i = 0; i <= k; i++) {

            int[] temp = dist.clone();

            for (int[] flight : flights) {

                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (dist[from] != Integer.MAX_VALUE &&
                    dist[from] + price < temp[to]) {

                    temp[to] = dist[from] + price;
                }
            }

            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}