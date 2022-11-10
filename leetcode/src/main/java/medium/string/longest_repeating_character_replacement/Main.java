package medium.string.longest_repeating_character_replacement;


/**
 * 424. Longest Repeating Character Replacement
 *
 * You are given a string s and an integer k. You can choose any character of the string and
 * change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after
 * performing the above operations.
 *
 *
 * EXAMPLE
 *
 *      Input: s = "ABAB", k = 2
 *      Output: 4
 *      Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 *  SOLUTION
 *
 *      Sliding Window
 *
 *  1) Create an array with the count of characters in the current window;
 *  2) Update maxCharInWindow if the value for the current character is bigger;
 *  3) If the count of characters that can be replaced is less the lengthOfWindow - maxCharInWindow =< k -> move the right cursor;
 *  4) If the count of characters that can be replaced is less the lengthOfWindow - maxCharInWindow > k -> move left cursor
 *    and decrease in the array count of characters associated with the left cursor;
 *  5) Update the result if the window size is bigger.
 *
 *  COMPLEXITY
 *
 *  Time Complexity: O(N)
 *  Space Complexity: O(26) = O(1)
 *
 *  LINK
 *
 *  https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("ABAB", 2)); // output: 4
//        System.out.println(solution.characterReplacement("AABABBA", 1));  // output: 4
    }

    static class Solution {
        public int characterReplacement(String s, int k) {
            int[] chars = new int[26];
            int left = 0;
            int right = 0;
            int maxCharInWindow = 0;
            int result = 0;

            while (right < s.length()) {
                chars[s.charAt(right) - 'A']++;
                maxCharInWindow = Math.max(maxCharInWindow, chars[s.charAt(right) - 'A']);

                int canBeReplace = (right + 1) - left - maxCharInWindow;
                if (canBeReplace > k) {
                    chars[s.charAt(left) - 'A']--;
                    left++;
                }

                result = Math.max(result, (right + 1) - left);

                right++;
            }

            return result;
        }
    }
}
