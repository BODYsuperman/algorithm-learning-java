package com.alexjava.algorithms.binarytree;
import com.alexjava.common.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {

        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        int res = 0;
        queue.offer(root);
        
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size ; i++) {

                TreeNode node = queue.poll();
                if(i == 0){
                    res = node.val;
                }

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }

        }
        return res;

    }
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue1(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left,deep + 1);
        if (root.right != null) findLeftValue(root.right,deep + 1);
    }
}
