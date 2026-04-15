package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {


        if(root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) +1;

    }

    public static int maxDepthBFS(TreeNode root) {


        if( root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize ; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);


            }
        }
        return depth;
    }
}
