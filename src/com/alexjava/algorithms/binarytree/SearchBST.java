package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {


        if (root == null || root.val == val) return root;

        TreeNode res = new TreeNode();

        if (root.val > val) {
           res =  searchBST(root.left, val);
        } else {
            res =  searchBST(root.right, val);
        }
        return res;
    }

    public TreeNode searchBST1(TreeNode root, int val) {

        while (root != null){
            if(val < root.val){
                root = root.left;
            }
            else if(val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;

    }

}
