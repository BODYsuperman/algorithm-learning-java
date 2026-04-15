package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    public boolean isSymmetric1(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){


        if(left == null & right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;


        return compare(left.left, right.right) && compare(left.right, right.left);
    }


    //DFS

    public boolean isSymmetric2(TreeNode root){
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);

        }

        return true;

    }

}
