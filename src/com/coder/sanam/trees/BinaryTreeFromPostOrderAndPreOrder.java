package com.coder.sanam.trees;
import com.coder.sanam.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPostOrderAndPreOrder {
	
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer,Integer> inorderIndex = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
        	inorderIndex.put(inorder[i], i);
        }
        return buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inorderIndex);
    }

	private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inorderIndex) {
		if(preStart>preEnd || inStart > inEnd) return null;
		TreeNode node = new TreeNode(preorder[preStart]);
		int index = inorderIndex.get(node.val);
		int numsLeft = index - inStart;
		node.left = buildTreeHelper(preorder,preStart + 1,preStart + numsLeft,inorder,inStart, index - 1,inorderIndex);
		node.right = buildTreeHelper(preorder,preStart +numsLeft+ 1,preEnd,inorder,inStart, index + 1,inorderIndex);
		return node;
	}

}


