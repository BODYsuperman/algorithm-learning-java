package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.Stack;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {


        if(root == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;

        if(root.left != null && root.left.left == null && root.left.right == null){
            midValue += root.left.val;
        }

        int sum = midValue + leftValue + rightValue;  // 中
        return sum;

    }
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<> ();
        stack.add(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return result;
    }
}
