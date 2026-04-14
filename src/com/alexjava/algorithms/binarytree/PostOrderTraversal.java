package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root){

        List<Integer> res = new ArrayList<>();
        postorder(root, res);

        return res;

    }

    private void postorder(TreeNode root, List<Integer> res) {

        if(root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

}
