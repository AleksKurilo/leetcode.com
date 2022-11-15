package easy.string.valid_palindrome;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *ø
 * EXAMPLE
 *
 *      Input: s = "A man, a plan, a canal: Panama"
 *      Output: true
 *      Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // output; true
//        System.out.println(solution.isPalindrome("race a car"));  // output; false
//        System.out.println(solution.isPalindrome("ab_a"));  // output; true
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toLowerCase().toCharArray();
            Deque<Character> queue = new ArrayDeque<>();

            for (char c : chars) {
                if ((c >= 97 && c < 123) || (c > 47 && c < 58)) {
                    queue.push(c);
                }
            }

            boolean result = true;

            while (!queue.isEmpty()) {
                if (queue.size() == 1) {
                    break;
                }

                if (!queue.pop().equals(queue.pollLast())) {
                    result = false;
                    break;
                }
            }

            return result;
        }
    }
}
