package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {

    public static void main(String[] args) {
        // BST element on left will be less than root and element on right will be greater than root
        //Balance Tree is a tree in which the difference between the heights of left and right subtrees cannot be more than one for any node.
        BalanceBST balanceBST = new BalanceBST();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode treeNode = balanceBST.balanceBST(root);
        // Iterate over the tree and print the values
        System.out.println(treeNode.toString());
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int l = 0;
        int r = list.size() -1;
        return makeBalancedBST(l,r,list);
    }

    private TreeNode makeBalancedBST(int l,int r,List<Integer> list){
        if(l>r){
            return null;
        }

        int mid = l + (r-l)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = makeBalancedBST(l,mid-1,list);
        node.right = makeBalancedBST(mid+1,r,list);

        return node;
    }

    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
