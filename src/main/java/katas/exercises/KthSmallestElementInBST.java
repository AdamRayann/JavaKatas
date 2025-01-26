package katas.exercises;

/**
 * Kth Smallest Element in a Binary Search Tree
 *
 * Given a BST, write a function to find the Kth smallest element.
 *
 * Example:
 *
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *
 * The 3rd smallest element is 4.
 *
 * Expected time complexity is O(n), while n is the tree height.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementInBST {

    public static int kthSmallest(TreeNode root, int k) {
        int[] counter = {0};
        return inOrderTraversal(root, k, counter);
    }
    private static int inOrderTraversal (TreeNode node, int k, int[] counter) {

        if (node == null) {
            return -1;
        }

        int leftResult = inOrderTraversal(node.left, k, counter);
        if (leftResult != -1) {
            return leftResult;
        }

        counter[0]++;
        if (counter[0] == k) {
            return node.val;
        }
        return inOrderTraversal(node.right, k, counter);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int k = 3;
        int kthSmallestValue = kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element is: " + kthSmallestValue); // Output: 4
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
