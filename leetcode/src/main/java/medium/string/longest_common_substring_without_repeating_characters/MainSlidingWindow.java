package medium.string.longest_common_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 * EXAMPLE
 *
 *      Input: s = "abcabcbb"
 *      Output: 3
 *      Explanation: The answer is "abc", with the length of 3.
 *
 *
 * SOLUTION
 *
 *  Sliding Window
 *
 *  1) We use two cursors left and right and map for keeping the last position of each character.
 *  2) We move right cursor to the right until the end and put each character (position of character)
 *     that we meet in map.
 *
 *  3) If we have had already in map this character we:
 *      3.1) move lift cursor to the current position duplicate character;
 *      3.2) update position in the map for current position of duplicate character;
 *      NOTE: left cursor must move only to the right
 *
 *  4) For each move of the right cursor we are checking current length of uniq characters,
 *     comparing position for left and right cursors.
 *
 *  5) Loop would be finished when right cursor will reach the end of the line.
 *
 *
 *  COMPLEXITY
 *
 * Time complexity: O(n) where n and m size of strings
 * Space complexity: O(min(m,n))
 *
 * LINK
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class MainSlidingWindow {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Hello World!");
        System.out.println(solution.lengthOfLongestSubstring("pwwkew")); // output: 3
//        System.out.println(solution.lengthOfLongestSubstring("abba")); // output: 2
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> chars = new HashMap<>();

            int left = 0;
            int right = 0;
            int result = 0;

            while (right < s.length()) {
                char charAt = s.charAt(right);

                if (chars.containsKey(charAt)) {
                    left = Math.max(left, chars.get(charAt) + 1);
                    chars.put(charAt, right);
                }

                chars.put(charAt, right);
                result = Math.max(result, right - left + 1);

                right++;
            }

            return result;
        }
    }
}
