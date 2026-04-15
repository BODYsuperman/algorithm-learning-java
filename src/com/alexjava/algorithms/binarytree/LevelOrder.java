package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> itemList = new ArrayList<>();

            while (size > 0) {
                TreeNode node = queue.poll();
                itemList.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                size--;
            }

            resList.add(itemList);
        }

        return resList;
    }




}
