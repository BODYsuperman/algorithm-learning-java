package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.ArrayDeque;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        swapChildren(root);

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public  TreeNode invertTree02(TreeNode root){
        if(root == null) return null;

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()){
            int size = deque.size();

            while (size-- > 0){
                TreeNode node = deque.poll();
                swapChildren(node);

                if(root.left != null) deque.offer(root.left);
                if(root.right != null) deque.offer(root.right);
            }
        }
        return root;

    }

    private  void swapChildren(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
