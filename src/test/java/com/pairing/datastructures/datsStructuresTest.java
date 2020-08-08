package com.pairing.datastructures;

import com.paring.datastructures.BinaryTree;
import com.paring.datastructures.MinStack;
import com.paring.datastructures.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class datsStructuresTest {

    @Test
    public void minStackTest() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin()); // return -3
        minStack.pop();
        assertEquals(0, minStack.top());    // return 0
        assertEquals(-2, minStack.getMin()); // return -2
    }

    @Test
    public void diameterofTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        assertEquals(4, tree.diameter(tree.root));
    }

    @Test
    public void constructTreeWithPreOrderTest() {
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.constructTreeWithPreOderTraversal(new int[]{8, 5, 1, 7, 10, 12});
        List<Integer> mylist = tree.traverseAsLevelOrder(root);
        //System.out.println(mylist.toString());
        TreeNode root1 = tree.constructTreeWithPreOderTraversal1(new int[]{8, 5, 1, 7, 10, 12});
        tree.preOdrerTraversal(root1);
        // tree.preOdrerTraversal(root);
    }


}
