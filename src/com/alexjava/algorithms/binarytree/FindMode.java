package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindMode {


    TreeNode pre = null;
    int maxCount = 0;
    int count = 0;

    List<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        inorder(root);

        return  res.stream().mapToInt(i ->i ).toArray();

    }

    private void inorder(TreeNode root) {

        if(root == null) return;
        inorder(root.left);

        if(pre == null || root.val != pre.val){
            count = 1;
        }
        else {
            count++;
        }

        if(count > maxCount){
            maxCount = count;
            res.clear();
            res.add(root.val);
        }else if(count == maxCount){
            res.add(root.val);
        }

        pre = root;

        inorder(root.right);

    }
}
