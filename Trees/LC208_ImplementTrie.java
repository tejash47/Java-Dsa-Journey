/*
 * LeetCode 208 - Implement Trie (Prefix Tree)
 *
 * Difficulty: Medium
 * Topic: Trie, Tree, String
 *
 * Approach:
 * - Each TrieNode contains 26 children for lowercase English letters.
 * - Each node also stores whether a complete word ends there.
 * - insert() creates missing nodes and marks the final node.
 * - search() traverses the Trie and checks isEnd.
 * - startsWith() checks whether the prefix path exists.
 *
 * Time Complexity:
 * insert()     : O(L)
 * search()     : O(L)
 * startsWith() : O(L)
 *
 * Space Complexity: O(N * L)
 *
 * where:
 * L = length of the word/prefix
 * N = number of inserted words
 */

class Trie {

    private static class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode node = findNode(word);

        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {

        return findNode(prefix) != null;
    }

    private TrieNode findNode(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }
}