package com.coder.sanam;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class InOrderTraversal {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null ) return result;
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){

            while(curr != null){
            stack.push(curr);
            curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
        
    }

    
}
