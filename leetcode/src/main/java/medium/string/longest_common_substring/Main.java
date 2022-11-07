package medium.string.longest_common_substring;

/**
 * The longest common substring
 *
 * Find the longest substring in two string.
 *
 * EXAMPLE
 *
 *      S1="caba", S2="abac"
 *      Result: "aba"
 *      Output: "3"
 *
 * SOLUTION
 *
 * 1. Build table
 *         c   a   b   a
 *      0   0   0   0   0
 *  a   0   -   -   -   -
 *  b   0   -   -   -   -
 *  a   0   -   -   -   -
 *  c   0   -   -   -   -
 *
 * 2. Use algorithm
 * if (S1.charAt[i] == S2.charAt[j]) ->  table[i - 1][j - 1] + 1
 *
 * 3. Fill the table
 *
 *         c   a   b   a
 *      0   0   0   0   0
 *  a   0   -   1   -   1
 *  b   0   -   -   2   -
 *  a   0   -   1   -   3
 *  c   0   1   -   -   -
 *
 *
 * COMPLEXITY
 *
 * Time complexity: O(n*m) where n and m size of strings
 * Space complexity: O(n*m) where n and m size of strings
 *
 * Link (see Solution): https://leetcode.com/problems/longest-palindromic-substring/solution/
 */
class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution solution = new Solution();
//        System.out.println(solution.longestCommonSubstring("caba", "abac"));
        System.out.println(solution.longestCommonSubstring("cbbd", "dbbc"));
//        System.out.println(solution.longestCommonSubstring("abacdfgdcaba", "abacdgfdcaba"));
    }

    static class Solution {
        public String longestCommonSubstring(String s1, String s2) {
            int[][] table = new int[s1.length() + 1][s2.length() + 1];
            int result = 0;
            table[0][0] = 0;

            // run through table
            for (int i = 1; i < s1.length() + 1; i++) {
                for (int j = 1; j < s2.length() + 1; j++) {
                    char charAtS1 = s1.charAt(i - 1);
                    char charAtS2 = s2.charAt(j - 1);
                    if (charAtS1 == charAtS2) {
                        table[i][j] = table[i - 1][j - 1] + 1;
                        if(result < table[i][j]){
                            result = table[i][j];
                        }
                    } else {
                        table[i][j] = 0;
                    }
                }
            }

            return String.valueOf(result);
        }
    }

}
