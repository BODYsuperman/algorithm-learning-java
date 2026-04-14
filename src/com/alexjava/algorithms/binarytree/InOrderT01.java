package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderT01 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();

        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()){
            if(cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            else{
                cur = deque.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;

    }
}
