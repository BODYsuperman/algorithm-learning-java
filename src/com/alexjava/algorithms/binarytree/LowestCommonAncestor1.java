package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

public class LowestCommonAncestor1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            return root;
        }
        return null;

    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    }
