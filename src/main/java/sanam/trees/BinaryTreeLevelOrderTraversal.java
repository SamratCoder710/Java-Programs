package sanam.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> resultSet = new ArrayList<>();
	        if (root == null) {
	            return resultSet;
	        }

	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);

	        while(!queue.isEmpty()){
	            int levelSize = queue.size();
	            List<Integer> currentLevel = new ArrayList<>();

	            for(int i=0;i<levelSize;i++){
	                TreeNode current = queue.poll();
	                currentLevel.add(current.val);
	                
	                if (current.left != null) {
	                    queue.offer(current.left);
	                }

	                if (current.right != null) {
	                    queue.offer(current.right);
	                }
	            }
	            resultSet.add(currentLevel);

	        }
	        return resultSet; 
	    }

}


