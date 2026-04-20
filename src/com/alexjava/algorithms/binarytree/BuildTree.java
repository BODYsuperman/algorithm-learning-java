package com.alexjava.algorithms.binarytree;
import com.alexjava.common.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class BuildTree {


    Map<Integer, Integer> map =  new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }


        return dfs(inorder, 0, inorder.length-1, postorder, 0, postorder.length -1);

    }

    private TreeNode dfs(int[] inorder, int inL, int inR , int[] postorder, int postL, int postR) {

        if(inL > inR) return null;

        int rootVal = postorder[postR];

        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);

        int leftSize = index - inL;


        root.left = dfs(inorder, inL, index-1, postorder, postL, postL + leftSize -1);

        root.right = dfs(inorder, index+1, inR, postorder, postL + leftSize, postR-1);

        return root;


    }
}
