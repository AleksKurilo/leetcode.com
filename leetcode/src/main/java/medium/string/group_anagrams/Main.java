package medium.string.group_anagrams;

import java.util.*;


/**
 * 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
 * using all the original letters exactly once.
 *
 * EXAMPLE
 *
 *      Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *      Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * SOLUTION
 *      see: {@link easy.string.valid_anagram.Main}
 *
 * COMPLEXITY
 *
 * Time complexity:    O(N K logK)
 * Space complexity:   O(N K)
 *
 * LINK
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams("eat", "tea", "tan", "ate", "nat", "bat"));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String... strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {
                String key = buildKey(s);
                List<String> value = new ArrayList<>();
                value.add(s);
                map.computeIfAbsent(key, s1 -> new ArrayList<>());
                map.computeIfPresent(key, (s1, strings) -> {
                    strings.add(s);
                    return strings;
                });
            }

            return new ArrayList<>(map.values());
        }

        private String buildKey(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }
}
