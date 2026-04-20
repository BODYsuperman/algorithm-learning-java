package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

public class IsValidBST {
    TreeNode pre = null;

    public  boolean isValidBST(TreeNode root){

        if(root == null) return true;

        if(!isValidBST(root.left)) return  false;

        if(pre != null && root.val <= pre.val) return false;

        pre = root;

        return  isValidBST(root.right);
    }
}
