package easy.array.two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices
 * of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * EXAMPLE
 *
 *     Input: nums = [2,7,11,15], target = 9
 *     Input: nums = [2,7,11,15], target = 9
 *     Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * COMPLEXITY
 *
 * Time complexity:    O(n)
 * Space complexity:   O(n)
 *
 * LINK
 *
 * https://leetcode.com/problems/two-sum/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        System.out.println(String.format("[%s, %s]", result[0], result[1]));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int compute = target - nums[i];
                if (map.containsKey(compute)) {
                    return new int[]{map.get(compute), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}
