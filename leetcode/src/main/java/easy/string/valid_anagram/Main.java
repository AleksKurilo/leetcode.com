package easy.string.valid_anagram;

import java.util.Arrays;

/**
 *
 * 242. Valid Anagram
 *
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all
 * the original letters exactly once.
 *
 * LINK
 *
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution1 solution = new Solution1();
        System.out.println(solution.isAnagram("anagram", "nagaram")); // output: true
        System.out.println(solution.isAnagram("rat", "car")); // output: false
    }

    // Use array to aggregate character
    // Runtime 22 ms
     static class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            int [] chars = new int[26];

            for(int i = 0; i< s.length(); i++){
                chars[s.charAt(i) - 'a']++;
                chars[t.charAt(i)- 'a']--;
            }

            for(int count : chars){
                if(count != 0){
                    return false;
                }
            }

            return true;
        }
    }

    // Use array sort
    // Runtime 2 ms
    static class Solution2 {
        public boolean isAnagram(String s, String t) {
            char[] ca = s.toCharArray();
            char[] ct = t.toCharArray();
            Arrays.sort(ca);
            Arrays.sort(ct);
            String ss = new String(ca);
            String st = new String(ct);
            return ss.equals(st);
        }
    }
}
