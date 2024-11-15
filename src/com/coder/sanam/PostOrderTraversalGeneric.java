package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversalGeneric {
	
	public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        POT(root,result);
        return result;
    }

    private void POT(Node node,List<Integer> result){
        if(node == null) return;
        for(int i=0;i<node.children.size();i++){
            POT(node.children.get(i),result);
        }
        result.add(node.val);
    }
    
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
