package stack.binary;

import java.util.*;

public class BinaryTreeIterativeTraversal {
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
	}
	
	class State{
		TreeNode node;
		boolean visited;
		
		State(){};
		State(TreeNode node, boolean visited){
			this.node = node;
			this .visited = visited;
		}
	}
	
	public List<Integer> postOrderTraverseRecurs(TreeNode root){
		if(root == null) return List.of();
		
		List<Integer> res = new ArrayList<Integer>();
		
		postOrderTraverseRecurs(root.left);
		postOrderTraverseRecurs(root.right);
		res.add(root.val);
		System.out.println(root.val);

		return res;
	}

	public List<Integer> inOrderTraverseRecurs(TreeNode root){
		if(root == null) return null;
		
		List<Integer> res = new ArrayList<Integer>();
		
		inOrderTraverseRecurs(root.left);
		res.add(root.val);
		System.out.println(root.val);
		inOrderTraverseRecurs(root.right);
		
		return res;
	}
	
	public List<Integer> preOrderTraversalRecurs(TreeNode root){
		if(root == null) return null;
		
		List<Integer> res = new ArrayList<Integer>();
		
		res.add(root.val);
		System.out.println(root.val);
		preOrderTraversalRecurs(root.left);
		preOrderTraversalRecurs(root.right);
		
		return res;
	}
	
	// default is preorder: that is we process the node as soon as we
	// reach the node.
	public List<Integer> preorderTraversal(TreeNode root){
		if(root == null) return List.of();
		
		Stack<State> stack = new Stack<>();
		
		List<Integer> res = new ArrayList<Integer>();
		stack.push(new State(root, false));
		
		while(!stack.isEmpty()) {
			State cur = stack.pop();
			
			if(cur.node == null) continue;
			
			if(cur.visited) {
				res.add(cur.node.val);
			} else { // reverse order: root->left-right becomes right->left->root
				if(cur.node.right != null) stack.push(new State(cur.node.right, false));
				if(cur.node.left != null) stack.push(new State(cur.node.left, false));
				stack.push(new State(cur.node, true)); // re-pushing, pushing last to process first
			}
		}
		return res;
	}
	
	public List<Integer> inOrderTraversalIterative(TreeNode root) {
		if(root == null) return List.of();
		
		Stack<State> stack = new Stack<>();
		List<Integer> res = new ArrayList<Integer>();
		
		stack.push(new State(root, false));
		
		while(!stack.isEmpty()) {
			State cur = stack.pop();
			
			if(cur.node == null) continue;
			
			if(cur.visited) {
				res.add(cur.node.val);
			} else { // reverse order: original: left->root->right; reverse: right->root->left
				if(cur.node.right != null) stack.push(new State(cur.node.right, false));
				stack.push(new State(cur.node, true));
				if(cur.node.left != null) stack.push(new State(cur.node.left, false));
			}
		}
		return res;
	}

	public List<Integer> postOrderTraversalIterative(TreeNode root){
		if(root == null) return List.of();
		
		Stack<State> stack = new Stack<>();
		List<Integer> res = new ArrayList<Integer>();
		stack.push(new State(root, false));
		
		while(!stack.isEmpty()) {
			State cur = stack.pop();
			
			if(cur.node == null) continue;
			
			if(cur.visited) {
				res.add(cur.node.val);
			} else { // reverse, original order: left->right->root: reversed: root->right->left
				stack.push(new State(cur.node, true));
				if(cur.node.right != null) stack.push(new State(cur.node.right, false));
				if(cur.node.left != null) stack.push(new State(cur.node.left, false));
			}
		}
		return res;
	}
	
	public static void main(String a[]) {
		BinaryTreeIterativeTraversal ob = new BinaryTreeIterativeTraversal();
		
		TreeNode root = ob.new TreeNode(1);
    	TreeNode two = ob.new TreeNode(2);
    	TreeNode three = ob.new TreeNode(3);
    	TreeNode four = ob.new TreeNode(4);
    	TreeNode five = ob.new TreeNode(5);
    	TreeNode six = ob.new TreeNode(6);
    	TreeNode seven = ob.new TreeNode(7);
    	TreeNode eight = ob.new TreeNode(8);
    	
    	root.left = two;
    	root.right = three;
    	two.left = four;
    	two.right = five;
    	three.left = six;
    	three.right = seven;
    	four.left = eight;
    	
    	List<Integer> res = ob.preorderTraversal(root);
    	
    	System.out.println("pre order: ");
    	for(int n: res) {
    		System.out.println(n);
    	}
    	
    	
    	List<Integer> in = ob.inOrderTraversalIterative(root);
    	System.out.println("in order: ");

    	for(int n: in) {
    		System.out.println(n);
    	}
    	
    	List<Integer> post = ob.postOrderTraversalIterative(root);
    	System.out.println("post order: ");

    	for(int n: post) {
    		System.out.println(n);
    	}
	}
}
