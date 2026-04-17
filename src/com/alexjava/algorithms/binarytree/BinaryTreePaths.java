package com.alexjava.algorithms.binarytree;

import com.alexjava.common.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);


        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        System.out.println(binaryTreePaths.binaryTreePaths(root));

    }
    public  List<String> binaryTreePaths(TreeNode root){


        List<String> res = new ArrayList<>();

        if(root == null) return res;

        List<Integer> path = new ArrayList<>();

        dfs(root, path, res);

        
        return res;

    }

    private  void dfs(TreeNode node, List<Integer> path, List<String> res) {

        path.add(node.val);
        // 叶子节点
        if (node.left == null && node.right == null) {
            res.add(buildPath(path));
        } else {
            if (node.left != null) dfs(node.left, path, res);
            if (node.right != null) dfs(node.right, path, res);
        }

        path.remove(path.size() -1);

    }

    private  String buildPath(List<Integer> path) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if(i != path.size() -1){
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
