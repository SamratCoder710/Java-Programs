package sanam.trees;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {
	
	
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list = new ArrayList<>();
		POT(root1,list);
		return false;
        
    }
	
	public void POT(TreeNode root, List<Integer> list) {
		if(root == null) return ;
		if(root.right== null && root.left == null) {
			list.add(root.val);
		}
		POT(root.left,list);
		POT(root.right,list);
	}
}


