package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;


        if(root.val < key){
            root.right  = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left == null) return  root.right;
            if(root.right == null) return root.left;

            TreeNode tmp = root.right;


            while (tmp.left != null) {
                tmp = tmp.left;
            }
            root.val = tmp.val;
            root.right = deleteNode(root.right,tmp.val);
        }
        return root;
    }
}
