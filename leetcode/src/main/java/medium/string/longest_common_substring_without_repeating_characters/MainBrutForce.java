package medium.string.longest_common_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class MainBrutForce {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Hello World!");
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    static class Solution {
        Set<Character> result = new HashSet<>();
        Set<Character> substring = new HashSet<>();

        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();

            int position = 0;
            while (position != chars.length) {
                for (int i = position; i < chars.length; i++) {
                    if (!substring.contains(chars[i])) {
                        substring.add(chars[i]);
                    } else {
                        isCompareAndReplace();
                        break;
                    }
                }

                position++;
            }

            return result.size();
        }

        private void isCompareAndReplace() {
            if (result.size() < substring.size()) {
                result = this.substring;
            }
            this.substring = new HashSet<>();
        }
    }
}
