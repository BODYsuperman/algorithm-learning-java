package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.*;

public class PostOrderT01 {

    public List<Integer> postorderTraversal(TreeNode root){

        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;


        //mid left right
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);

            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }


        }

        Collections.reverse(res);

        return res;
    }
}
