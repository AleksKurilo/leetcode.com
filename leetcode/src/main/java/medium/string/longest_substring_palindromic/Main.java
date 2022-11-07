package medium.string.longest_substring_palindromic;


/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * EXAMPLE
 *
 *      Input: s = "babad"
 *      Output: "bab"
 *      Explanation: "aba" is also a valid answer.
 *
 * SOLUTION
 *
 *  Expand Around Center
 *
 *  We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center,
 *  and there are only 2n−12n - 12n−1 such centers.
 *
 *  cases:
 *  1)  b   a   b   a   d
 *          ^
 *
 *  2)  c   b     b   d
 *             ^
 *
 * COMPLEXITY
 *
 * Time complexity:    O(n ^ 2)
 * Space complexity:   O(1)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
     // System.out.println(solution.longestPalindrome("cbbd"));

    }

    public static class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            int start = 0;
            int end = 0;

            for (int i = 0; i < n; i++) {
                int len_odd = expandAroundCenter(s, i, i);
                int len_even = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len_odd, len_even);

                if (len > end - start) {
                    start = i - (len -1) / 2;
                    end = i + len / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        int expandAroundCenter(String s, int left, int right) {
            int l = left;
            int r = right;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            return r - l - 1;
        }
    }

}
