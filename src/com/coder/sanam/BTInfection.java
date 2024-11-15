package com.coder.sanam;

import java.util.*;

import com.coder.sanam.SymmetricTreeNode.TreeNode;

public class BTInfection {
	
	private static Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

    public static int amountOfTime(TreeNode root, int start) {
        convertToGraph(root);
        System.out.println(adjacencyList);
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
      // queue  1  10
        // visted: 3
      //time : 0  
        queue.offer(start);
        int time = -1; 
//        {1=[3, 5], 2=[4], 3=[1, 10], 
//        4=[2, 5, 9], 5=[1, 4], 6=[10], 9=[4], 10=[3, 6]}     
        while (!queue.isEmpty()) {
            time++;
            // i = 1;i>0
            for (int i = queue.size(); i > 0; i--) {
                int currentNode = queue.pollFirst();
                visited.add(currentNode);
              
                if (adjacencyList.containsKey(currentNode)) {
                    for (int neighbor : adjacencyList.get(currentNode)) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return time;
    }

    private static void convertToGraph(TreeNode node) {
        if (node == null) {
            return;
        }
      
        if (node.left != null) {
            adjacencyList.computeIfAbsent(node.val, k -> new HashSet<>()).add(node.left.val);
            adjacencyList.computeIfAbsent(node.left.val, k -> new HashSet<>()).add(node.val);
        }
      
        if (node.right != null) {
            adjacencyList.computeIfAbsent(node.val, k -> new HashSet<>()).add(node.right.val);
            adjacencyList.computeIfAbsent(node.right.val, k -> new HashSet<>()).add(node.val);
        }
      
        
        convertToGraph(node.left);
        convertToGraph(node.right);
    }
    

	
	public static void main(String[] args) {
		SymmetricTreeNode symmetricTreeNode = new SymmetricTreeNode();
		SymmetricTreeNode.TreeNode root = symmetricTreeNode.new TreeNode(1,
                symmetricTreeNode.new TreeNode(5, null, symmetricTreeNode.new TreeNode(4, symmetricTreeNode.new TreeNode(9), symmetricTreeNode.new TreeNode(2))),
                symmetricTreeNode.new TreeNode(3, symmetricTreeNode.new TreeNode(10, symmetricTreeNode.new TreeNode(6), null), null));
		int amountOfTime = amountOfTime(root, 3);
		System.out.println(amountOfTime);
	}
}
