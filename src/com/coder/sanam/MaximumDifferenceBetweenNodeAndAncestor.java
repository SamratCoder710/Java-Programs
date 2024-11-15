package com.coder.sanam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.coder.sanam.InOrderTraversal.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
	
	
	private static Map<Integer,Set<Integer>> childMap =  new HashMap<>();
	
    public static int maxAncestorDiff(TreeNode root) {
        convertToChildMap(root);
        int max = 0;
        for(Entry<Integer, Set<Integer>> entry : childMap.entrySet()) {
        	int parent  = entry.getKey();
        	for(int child : entry.getValue()) {
        		if(childMap.containsKey(child)) {
        			Set<Integer> set = childMap.get(child);
        			for(int k:set) {
        				int diff = Math.abs(parent - k);
                		max = Math.max(diff, max);
        			};
        			
        		}
        		int diff = Math.abs(parent - child);
        		max = Math.max(diff, max);
        	}
        }
        return max;
        
    }

	private static void convertToChildMap(TreeNode root) {
		if(root == null) return;
		if(root.left != null) {
			childMap.computeIfAbsent(root.val, k -> new HashSet<>()).add(root.left.val);
		}
		if(root.right != null) {
			childMap.computeIfAbsent(root.val, k -> new HashSet<>()).add(root.right.val);
		}
		convertToChildMap(root.left);
		convertToChildMap(root.right);
	}
	
	public static void main(String[] args) {
		SymmetricTreeNode  symmetricTreeNode = new SymmetricTreeNode();
		SymmetricTreeNode.TreeNode root = symmetricTreeNode.new TreeNode(8,
                symmetricTreeNode.new TreeNode(3,
                    symmetricTreeNode.new TreeNode(1),
                    symmetricTreeNode.new TreeNode(6,
                        symmetricTreeNode.new TreeNode(4),
                        symmetricTreeNode.new TreeNode(7)
                    )
                ),
                symmetricTreeNode.new TreeNode(10,
                    null,
                    symmetricTreeNode.new TreeNode(14,
                        symmetricTreeNode.new TreeNode(13),
                        null
                    )
                )
            );
		
	}

}
