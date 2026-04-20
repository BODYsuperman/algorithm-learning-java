package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //left right mid
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;


        return null;
    }
}
