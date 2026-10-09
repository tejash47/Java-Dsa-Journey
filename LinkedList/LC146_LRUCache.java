/*
 * LeetCode 146 - LRU Cache
 *
 * Difficulty: Medium
 * Topic: HashMap, Doubly Linked List, Design
 *
 * Approach:
 * - Use a HashMap for O(1) key lookup.
 * - Use a doubly linked list to track usage order.
 * - Move recently accessed nodes to the front.
 * - Evict the least recently used node from the back.
 *
 * Time Complexity:
 * get() : O(1) average
 * put() : O(1) average
 *
 * Space Complexity: O(capacity)
 */

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        if (cache.size() == capacity) {
            Node leastRecent = tail.prev;
            remove(leastRecent);
            cache.remove(leastRecent.key);
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToFront(newNode);
    }

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}