package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            return  new TreeNode(val);
        }

        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        else if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;

    }
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode cur = root;

        while (true) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }
        }

        return root;
    }
}
