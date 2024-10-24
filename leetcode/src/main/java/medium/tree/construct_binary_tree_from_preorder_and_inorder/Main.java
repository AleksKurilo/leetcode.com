package medium.tree.construct_binary_tree_from_preorder_and_inorder;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
 * is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * <p>
 * SOLUTION
 * <p>
 *	• A given pre-order traversal sequence is used to find the root node of the binary tree to be constructed. The root node is then used to find its own index it the given in-order traversal sequence.
 * 		○ This is needed for construction the left and the right sub-trees of the root node.
 *<p>
 * 	• The given in-order traversal sequence is used to find the range of nodes that are in the left sub-tree and the right sub-tree.
 * 		○ The left sub-tree will have the nodes in the nodes in the range [start, index - 1]
 * The right sub-tree will have the nodes in the range [index + 1, end]
 *  LINK
 *  * <p>
 *  * see solution in notes "2.2 Algorithm: Construct a binary tree form INORDER & PREORDER traversal".
 */
public class Main {

    public static void main(String[] args) {

        /* Construct the following tree
                   10
                  /  \
                 12   30
                /    /  \
               44   50   16
        */

        List<Integer> pre_order_seq = Arrays.asList(10, 12, 44, 30, 50, 16);
        List<Integer> in_order_seq = Arrays.asList(44, 12, 10, 50, 30, 16);

        System.out.print("Given in-order traversal : ");
        for (int node : in_order_seq) {
            System.out.print(node + " ");
        }
        System.out.println();

        System.out.print("Given pre-order traversal : ");
        for (int node : pre_order_seq) {
            System.out.print(node + " ");
        }
        System.out.println();

        Tree t = new Tree(in_order_seq, pre_order_seq);
        Node root = t.construct(0, pre_order_seq.size() - 1);

        System.out.print("In-order traversal of the constructed tree : ");
        t.inOrderTraversal(root);

        System.out.print("\nPre-order traversal of the constructed tree : ");
        t.preOrderTraversal(root);
    }
}

class Node {

    int val;
    Node left;
    Node right;

    Node(int x) {
        this.val = x;
    }
}

class Tree {

    List<Integer> in_order;
    List<Integer> pre_order;
    HashMap<Integer, Integer> map_in_order;
    int pre_order_index;

    Tree(List<Integer> in_order_seq, List<Integer> pre_order_seq) {

        in_order = new ArrayList<Integer>(in_order_seq);
        pre_order = new ArrayList<Integer>(pre_order_seq);
        map_in_order = new HashMap<Integer, Integer>();
        pre_order_index = 0;

        // Use an unordered_map to find the index of a node in the inorder sequence
        for (int index = 0; index < pre_order_seq.size(); index++) {
            map_in_order.put(in_order_seq.get(index), index);
        }
    }

    // Recursively construct a binary tree from an in_order and pre_order sequence
    Node construct(int start, int end) {

        // Check if all the nodes in the pre-order sequence are processed. i.e if end < start
        if (start > end) {
            return null;
        }

        Node root = new Node(pre_order.get(pre_order_index));

        // Process the nodes from left to right
        pre_order_index += 1;

        /* Fetch the index of the root node in the in_order sequence
           to get the range of the left and right subtree nodes. */
        int index = map_in_order.get(root.val);

        // Recursively construct the left sub-tree
        root.left = construct(start, index - 1);

        // Recursively construct the right sub-tree
        root.right = construct(index + 1, end);

        return root;
    }

    // Recursive function for inorder traversal
    void inOrderTraversal(Node root) {

        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    // Recursive function for preorder traversal
    void preOrderTraversal(Node root) {

        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

}
