package com.coder.sanam;

public class SumRootToLeaf {

    public static void main(String[] args) {
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(0);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        int res = sumRootToLeaf.sumRootToLeaf(root);
        System.out.println(res);
    }

    public int sumRootToLeaf(TreeNode root) {
        return solve(0,root);
    }

    private int solve(int result, TreeNode root){
        if(root == null){
            return 0;
        }

        result = (2*result) + root.val;
        if (root.left == null && root.right == null) {
            return result;
        } // Condition to return value on leaf
        return solve(result,root.left) + solve(result, root.right);
    }
}
