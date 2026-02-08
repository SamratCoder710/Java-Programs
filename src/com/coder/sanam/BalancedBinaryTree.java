package com.coder.sanam;

public class BalancedBinaryTree {

        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }



        private int findHeight(TreeNode root){
            if(root == null) return 0;

            int left = findHeight(root.left);
            int right = findHeight(root.right);

            return Math.max(left,right) + 1;
        }

        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;

            int leftH = findHeight(root.left);
            int rightH = findHeight(root.right);

            if(Math.abs(leftH - rightH) > 1){
                return false;
            }

            return isBalanced(root.left) && isBalanced(root.right);
        }

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        // root = [1,2,2,3,3,null,null,4,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        boolean balanced = balancedBinaryTree.isBalanced(root);
        System.out.println(balanced);

    }

}
