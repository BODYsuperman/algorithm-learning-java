package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        inorder(root , res);
        return res;

    }

    private void inorder(TreeNode root, List<Integer> list) {


        //left mid right

        if(root == null) return;
        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);


    }


}
