/*
 * LeetCode 278 - First Bad Version
 *
 * Difficulty: Easy
 * Topic: Binary Search
 *
 * Approach:
 * - Use Binary Search on versions [1, n].
 * - If mid is a bad version, search the left half.
 * - Otherwise, search the right half.
 * - The left pointer will point to the first bad version.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
*/

class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
