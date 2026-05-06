package com.alexjava.algorithms.dp;

import com.alexjava.common.structures.TreeNode;

public class Rob3 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {

        if(root == null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int noRob = Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        int rob = root.val + left[0] + right[0];

        return new int[]{noRob, rob};
    }

}
