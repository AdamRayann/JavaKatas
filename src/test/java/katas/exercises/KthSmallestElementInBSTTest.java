package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class KthSmallestElementInBSTTest {

    @Test
    void testBasicBSTExample() {
        // Constructing the BST
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(6);
        root.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.right = new KthSmallestElementInBST.TreeNode(4);

        // Testing the example case
        assertEquals(4, KthSmallestElementInBST.kthSmallest(root, 3));
    }

    @Test
    void testKEqualsOne() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(6);
        root.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.right = new KthSmallestElementInBST.TreeNode(4);

        // The 1st smallest element should be 2
        assertEquals(2, KthSmallestElementInBST.kthSmallest(root, 1));
    }

    @Test
    void testKEqualsTotalNodes() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(6);
        root.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.right = new KthSmallestElementInBST.TreeNode(4);

        // The last (5th) smallest element should be 6
        assertEquals(6, KthSmallestElementInBST.kthSmallest(root, 5));
    }

    @Test
    void testSingleNodeTree() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(10);

        // The only element in the tree
        assertEquals(10, KthSmallestElementInBST.kthSmallest(root, 1));
    }

    @Test
    void testRightSkewedTree() {
        // Constructing a right-skewed tree (like a linked list)
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(1);
        root.right = new KthSmallestElementInBST.TreeNode(2);
        root.right.right = new KthSmallestElementInBST.TreeNode(3);
        root.right.right.right = new KthSmallestElementInBST.TreeNode(4);
        root.right.right.right.right = new KthSmallestElementInBST.TreeNode(5);

        // Testing different k values
        assertEquals(1, KthSmallestElementInBST.kthSmallest(root, 1));
        assertEquals(3, KthSmallestElementInBST.kthSmallest(root, 3));
        assertEquals(5, KthSmallestElementInBST.kthSmallest(root, 5));
    }

    @Test
    void testLeftSkewedTree() {
        // Constructing a left-skewed tree (like a linked list)
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(4);
        root.left.left = new KthSmallestElementInBST.TreeNode(3);
        root.left.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.left.left.left = new KthSmallestElementInBST.TreeNode(1);

        // Testing different k values
        assertEquals(1, KthSmallestElementInBST.kthSmallest(root, 1));
        assertEquals(3, KthSmallestElementInBST.kthSmallest(root, 3));
        assertEquals(5, KthSmallestElementInBST.kthSmallest(root, 5));
    }
}
