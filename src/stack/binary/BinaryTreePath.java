package stack.binary;

import java.util.*;

public class BinaryTreePath {
	class TreeNode {
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
		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}
	
	class NodeTuple {
		TreeNode node;
		String path;
		
		NodeTuple(){};
		NodeTuple(TreeNode node, String path){
			this.node = node;
			this.path = path;
		}
	}
	
	public List<String> dfsStack(TreeNode root){
		Stack<NodeTuple> stack = new Stack<>();
		
		stack.push(new NodeTuple(root, String.valueOf(root.val)));
		List<String> res = new ArrayList<String>();
		
		while(!stack.isEmpty()) {
			NodeTuple cur = stack.pop();
			
			if(cur.node.left == null && cur.node.right == null) {
				res.add(cur.path);
			}
			
			if(cur.node.right != null) 
				stack.push(
						new NodeTuple(
								cur.node.right, 
								cur.path + "->" + String.valueOf(cur.node.right)));
			
			if(cur.node.left != null) 
				stack.push(
						new NodeTuple(
								cur.node.left, 
								cur.path + "->" + String.valueOf(cur.node.left)));
		}
		return res;
	}
	
	public List<String> binaryTreePaths(TreeNode root){
		if(root == null) return List.of();
		
		if(root.left == null && root.right == null) {
			return List.of(String.valueOf(root.val));
		}
		
		List<String> allPath = new ArrayList<String>();
		
		List<String> left = binaryTreePaths(root.left);
		
		for(String aPath: left) {
			allPath.add(String.valueOf(root.val) +"->"+ aPath);
		}
		
		List<String> right = binaryTreePaths(root.right);
		for(String aPath: right) {
			allPath.add(String.valueOf(root.val)  +"->"+  aPath);
		}
		return allPath;
	}
	
	
	
	public static void main(String[] args) {
		BinaryTreePath ob = new BinaryTreePath();
		
		TreeNode root = ob.new TreeNode(1);
    	TreeNode two = ob.new TreeNode(2);
    	TreeNode three = ob.new TreeNode(3);
    	TreeNode five = ob.new TreeNode(5);
    	
    	root.left = two;
    	root.right = three;
    	two.right = five;
    	
    	System.out.println(ob.binaryTreePaths(root));
    	System.out.println(ob.dfsStack(root));
    	
	}
}
