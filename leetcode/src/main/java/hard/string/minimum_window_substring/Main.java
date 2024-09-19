package hard.string.minimum_window_substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * <p>
 * SOLUTION
 * <p>
 * Frequency Count: A frequency map keeps track of the characters required from t.
 * <p>
 * Sliding Window: A sliding window moves over the string s from the left (left) to the right (right) to find substrings
 * that include all characters of t.
 * <p>
 * Expand and Contract: The window expands by moving right and contracts by moving left when all required characters are found.
 * <p>
 * Result Storage: The smallest valid window is stored and returned at the end.
 * <p>
 * <p>
 * COMPLEXITY
 * <p>
 * 1. Variant
 * Time complexity:    O(N)
 * Space complexity:   O(m + n)
 * <p>
 * LINK
 * <p>
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String source01 = "ADOBECODEBANC", target01 = "ABC";

        String case01 = Solution.minWindow(source01, target01);

        System.out.println("Result: " + case01);

    }

    static class Solution {
        public static String minWindow(String s, String t) {
            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            // Frequency map for the target string t
            Map<Character, Integer> targetCount = new HashMap<>();
            for (char c : t.toCharArray()) {
                targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
            }

            // Variables for the sliding window
            int left = 0, right = 0;
            int required = targetCount.size();  // Number of unique characters in t
            int formed = 0;  // Number of unique characters in the current window matching t's frequency

            // Dictionary to keep track of characters in the current window
            Map<Character, Integer> windowCounts = new HashMap<>();

            // Result variables (window length, left index, right index)
            int[] result = {-1, 0, 0};  // (length, left, right)

            // Slide the window over s
            while (right < s.length()) {
                char c = s.charAt(right);
                windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

                // If the current character's count matches the target's count
                if (targetCount.containsKey(c) && windowCounts.get(c).intValue() == targetCount.get(c).intValue()) {
                    formed++;
                }

                // Try and shrink the window from the left
                while (left <= right && formed == required) {
                    c = s.charAt(left);

                    // Save the smallest window so far
                    if (result[0] == -1 || right - left + 1 < result[0]) {
                        result[0] = right - left + 1;
                        result[1] = left;
                        result[2] = right;
                    }

                    // Reduce the frequency of the left character in the window
                    windowCounts.put(c, windowCounts.get(c) - 1);
                    if (targetCount.containsKey(c) && windowCounts.get(c).intValue() < targetCount.get(c).intValue()) {
                        formed--;
                    }

                    left++;
                }

                // Expand the window from the right
                right++;
            }

            return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
        }
    }

}
