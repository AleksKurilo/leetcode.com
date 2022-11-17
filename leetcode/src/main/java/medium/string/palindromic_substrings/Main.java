package medium.string.palindromic_substrings;

/**
 * 647. Palindromic Substrings
 *
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 *
 * EXAMPLE:
 *
 *      Input: s = "abc"
 *      Output: 3
 *      Explanation: Three palindromic strings: "a", "b", "c".
 *
 *      Input: s = "aaa"
 *      Output: 6
 *      Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *  SOLUTION
 *
 *   see: {@link medium.string.longest_substring_palindromic.Main}
 *
 *  LINK
 *
 *  https://leetcode.com/problems/palindromic-substrings/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc")); // output: 3
        System.out.println(solution.countSubstrings("aaa")); // output: 6
    }

    static class Solution {
        public int countSubstrings(String s) {
            int count = 0;

            int index = 0;
            while (index < s.length()) {
                int odd_count = countOfPalindromic(s, index, index);
                int even_count = countOfPalindromic(s, index, index + 1);

                count = count + odd_count;
                count = count + even_count;

                index++;
            }

            return count;
        }

        private int countOfPalindromic(String s, int leftIndex, int rightIndex) {
            int count = 0;
            int left = leftIndex;
            int right = rightIndex;

            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                } else {
                    break;
                }
            }

            return count;
        }
    }
}
