package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }

        return  hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
