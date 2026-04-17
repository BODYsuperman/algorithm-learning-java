package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

public class IsBalanced {

    public  boolean isBalanced(TreeNode root){
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {

        if(root == null) return 0;

        int heightLeft = getHeight(root.left);
        if(heightLeft == -1){
            return -1;
        }

        int heightRight = getHeight(root.right);
        if(heightRight == -1){
            return -1;
        }

        if(Math.abs(heightLeft - heightRight) > 1){
            return -1;
        }


        return  Math.max(heightRight, heightLeft) + 1;




    }
}
