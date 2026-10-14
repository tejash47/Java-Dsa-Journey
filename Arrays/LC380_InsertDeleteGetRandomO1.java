/*
 * LeetCode 380 - Insert Delete GetRandom O(1)
 *
 * Difficulty: Medium
 * Topic: Array, Hash Table, Math, Design, Randomized
 *
 * Approach:
 * - Maintain an ArrayList for O(1) random access by index.
 * - Maintain a HashMap mapping value -> index in ArrayList for O(1) lookup.
 * - When removing, swap target element with last element in list, update map, and remove last element.
 *
 * Time Complexity: O(1) average for all operations
 * Space Complexity: O(n)
 */

import java.util.*;

class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        int lastVal = list.get(list.size() - 1);

        list.set(index, lastVal);
        map.put(lastVal, index);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
