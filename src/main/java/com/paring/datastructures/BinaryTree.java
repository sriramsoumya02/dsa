package com.paring.datastructures;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTree {

    public TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }

    public int diameter(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        return Math.max(1 + lh + rh, Math.max(ld, rd));
    }

    public TreeNode constructTreeWithPreOderTraversal(int[] preOrder) {
        List<Integer> preOrderList = IntStream.of(preOrder).boxed().collect(Collectors.toList());
        return recursiveForConstructTreeWithPreOrder(preOrderList);
    }

    public TreeNode recursiveForConstructTreeWithPreOrder(List<Integer> list) {
        TreeNode root = new TreeNode(list.get(0));
        List<Integer> leftTree = new ArrayList<>();
        List<Integer> righTree = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(0))
                leftTree.add(list.get(i));
            else
                righTree.add(list.get(i));
        }
        root.left = (!leftTree.isEmpty()) ? recursiveForConstructTreeWithPreOrder(leftTree) : null;
        root.right = (!righTree.isEmpty()) ? recursiveForConstructTreeWithPreOrder(righTree) : null;
        return root;
    }

    public TreeNode constructTreeWithPreOderTraversal1(int[] preOrder) {
        TreeNode root = new TreeNode(preOrder[0]);
        int i = 1;
        int len = preOrder.length;
        int[] leftTree = null, rightTree = null;
        while (i < len && preOrder[i] < root.val) {
            i++;
        }
        if (i >= 1) {
            leftTree = Arrays.copyOfRange(preOrder, 1, i);
            if (i < len)
                rightTree = Arrays.copyOfRange(preOrder, i, len);
        }
        root.left = (leftTree != null && leftTree.length > 0) ? constructTreeWithPreOderTraversal1(leftTree) : null;
        root.right = (rightTree != null && rightTree.length > 0) ? constructTreeWithPreOderTraversal1(rightTree) : null;
        return root;
    }

    public List<Integer> traverseAsLevelOrder(TreeNode root) {
        List<Integer> nodesList = new ArrayList<>();
        Queue<TreeNode> nodesQue = new LinkedList<>();
        nodesQue.add(root);
        while (!nodesQue.isEmpty()) {
            TreeNode node = nodesQue.poll();
            nodesList.add(node != null ? node.val : null);
            if (node != null && !(node.left == null && node.right == null)) {
                nodesQue.add(node.left);
                nodesQue.add(node.right);
            }
        }
        return nodesList;
    }

    public void preOdrerTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOdrerTraversal(root.left);
            preOdrerTraversal(root.right);
        }
    }

}


