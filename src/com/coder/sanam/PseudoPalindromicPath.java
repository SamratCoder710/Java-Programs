package com.coder.sanam;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PseudoPalindromicPath {
	private static int[] arr ;
	
	private static int result = 0;
	
	public static int pseudoPalindromicPaths (TreeNode root) {
		arr = new int[10];
        POT(root);
        
        return result;
    }

    
    public static void POT(TreeNode node){
        if(node== null) {
            return;
        }
        arr[node.val]++;
        System.out.println(node.val);
        if(node.left == null && node.right == null){
           int oddCounter = 0;
           for(int i=1;i<10;i++) {
        	   if(arr[i] %2 == 1) {
        		   oddCounter++;
        	   }
           }
           
           if(oddCounter <= 1) {
        	   result += 1;
           }
        }
        POT(node.left);
        POT(node.right);
        
        System.out.println(node.val);
        arr[node.val]--;
        
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(3, new TreeNode(3), new TreeNode(1)), new TreeNode(1,null,new TreeNode(1)));
        
//    	 TreeNode root = new TreeNode(
//                 8,
//                 new TreeNode(6, null, null),
//                 new TreeNode(
//                         9,
//                         new TreeNode(4,
//                                 new TreeNode(1, null, null),
//                                 new TreeNode(5, null, null)
//                         ),
//                         new TreeNode(4,
//                                 new TreeNode(8, null, null),
//                                 null
//                         )
//                 )
//         );
    	
    	int result = pseudoPalindromicPaths(root);
        System.out.println("Result: " + result);
    }
}
