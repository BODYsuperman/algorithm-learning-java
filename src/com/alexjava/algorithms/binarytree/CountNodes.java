package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {
    public int countNodes(TreeNode root) {

        if(root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null){
            left = left.left;
            leftDepth++;
        }

        while (right != null){
            right = right.right;
            rightDepth++;
        }
        if(leftDepth == rightDepth){
            return (2 << leftDepth) -1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;



    }

    public int countNodes01(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // 迭代法
    public int countNodes02(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                TreeNode cur = queue.poll();
                result++;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return result;
    }
}
