package medium.other.add_tow_nambers;

/**
 * Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * EXAMPLE
 *
 *      Input: l1 = [2,4,3], l2 = [5,6,4]
 *      Output: [7,0,8]
 *      Explanation: 342 + 465 = 807.
 *
 *
 * LINK
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    static class Solution {
        ListNode result = null;

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int remainder = 0;
            while (l1 != null || l2 != null) {
                int l1Value = l1 != null ? l1.val : 0;
                int l2Value = l2 != null ? l2.val : 0;

                int value = (l1Value + l2Value + remainder) % 10;
                remainder = (l1Value + l2Value + remainder) / 10;
                insert(value, result);
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ?  l2.next : null;
            }

            if (remainder != 0){
                insert(remainder, result);
            }

            return result;
        }

        private void insert(int data, ListNode result) {
            ListNode newNode = new ListNode(data);
            if (result == null) {
                this.result = newNode;
            } else {
                ListNode currentNode = result;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
