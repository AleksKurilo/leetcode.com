package easy.tree;

import javax.swing.tree.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest
 * leaf node.
 *
 *  *  LINK
 *  *
 *  *  https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        TreeNode right = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, null, right);

        Solution solution = new Solution();
        int depth = solution.maxDepth(root);

        System.out.println("Depth: " + depth);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
   static class Solution {

       public int maxDepth(TreeNode root) {
            return dive(root, 0);
        }

        private int dive(TreeNode node, int level) {
            if (node == null) {
                return level;
            }

            int left = dive(node.left, level);
            int right = dive(node.right, level);

            level = Math.max(left, right);
            level++;
            return level;
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
