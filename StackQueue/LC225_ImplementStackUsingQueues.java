/*
 * LeetCode 225 - Implement Stack using Queues
 *
 * Difficulty: Easy
 * Topic: Stack, Queue
 *
 * Approach:
 * - Use one queue.
 * - Push the element.
 * - Rotate the queue so that the newly added element
 *   becomes the front.
 * - Front of the queue always represents the top of the stack.
 *
 * Time Complexity:
 * - push(): O(n)
 * - pop(): O(1)
 * - top(): O(1)
 * - empty(): O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {

        queue = new LinkedList<>();
    }

    public void push(int x) {

        queue.offer(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {

        return queue.poll();
    }

    public int top() {

        return queue.peek();
    }

    public boolean empty() {

        return queue.isEmpty();
    }
}