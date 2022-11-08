package easy.string.valid_parentheses;

import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * EXAMPLE
 *     Input: s = "()[]{}"
 *     Output: true
 *
 * SOLUTION
 *
 * 1) Keep characters in queue and check;
 * 2) If new is an open character put in the queue;
 * 3) If not, take the previous one from the queue and compare them
 *
 * LINK
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution solution = new Solution();
        System.out.println(solution.isValid("]")); // output: false
//        System.out.println(solution.isValid("(({])")); // output: false
//        System.out.println(solution.isValid("[(({}))])")); // output: true
//        System.out.println(solution.isValid("()")); // output: true
    }

    static class Solution {

        private final Map<Character, Character> table = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );

        private final Stack<Character> queue = new Stack<>();

        public boolean isValid(String s) {
            int count = 0;
            boolean result = true;

            while (count < s.length()) {

                if (isOpen(s.charAt(count))) {
                    queue.push(s.charAt(count));
                } else {
                    char previouse = queue.empty() ? '0' : queue.pop();

                    if (isNotMatch(previouse, s.charAt(count))) {
                        result = false;
                        break;
                    }
                }

                count++;
            }

            if (!queue.empty()) {
                result = false;
            }

            return result;
        }

        private boolean isOpen(char open) {
            return table.containsKey(open);
        }

        private boolean isNotMatch(char open, char close) {

            if(table.get(open) == null){
                return true;
            }

            return  table.get(open) != close;
        }
    }
}
