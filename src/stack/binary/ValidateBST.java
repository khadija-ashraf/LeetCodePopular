package stack.binary;

import java.util.Stack;

public class ValidateBST {
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
	
    public boolean isValidBSTIterative(TreeNode root) {
    	return inOrderIterative(root);
    }
    
    public boolean inOrderIterative(TreeNode root) {
    	if(root == null) return true;
    	
    	TreeNode prev = null;
    	Stack<State> stack = new Stack<>();
    	stack.push(new State(root, false));
    	
    	while(!stack.isEmpty()) {
    		State cur = stack.pop();
    		
    		if(cur.node == null) continue;
    		
    		if(cur.visited) {
    			if(prev != null && cur.node.val <= prev.val) {
    				return false;
    			}
    			prev = cur.node;
    		} else { // original order: left->root->right; reversed: right->root->left
    			if(cur.node.right != null) stack.push(new State(cur.node.right, false));
    			stack.push(new State(cur.node, true));
    			if(cur.node.left != null) stack.push(new State(cur.node.left, false));
    		}
    	}
    	return true;
    }
    
    
//    https://www.youtube.com/shorts/R12aXIlvCh8
    	
    public boolean isValidBST(TreeNode root) {
    	return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long min, long max) {
    	if(root == null) return true;

    	if(root.val <= min || root.val >= max) return false;
    	
    	return dfs(root.left, min, root.val) &&
    			dfs(root.right, root.val, max);
    }
    
	public static void main(String[] args) {
		ValidateBST ob = new ValidateBST();
		
//		TreeNode root = ob.new TreeNode(2);
//    	TreeNode one = ob.new TreeNode(1);
//    	TreeNode three = ob.new TreeNode(3);
//    	
//    	root.left = one;
//    	root.right = three;
		// output: true

    	TreeNode root = ob.new TreeNode(5);
    	TreeNode one = ob.new TreeNode(1);
    	TreeNode three = ob.new TreeNode(3);
    	TreeNode four = ob.new TreeNode(4);
    	TreeNode six = ob.new TreeNode(6);
    	
    	root.left = one;
    	root.right = four;
    	four.left = three;
    	four.right = six;
		// output: false
		
    	
    	
//    	[5,4,6,null,null,3,7]
    	
//		TreeNode root = ob.new TreeNode(5);
//    	TreeNode four = ob.new TreeNode(4);
//    	TreeNode six = ob.new TreeNode(6);
//    	TreeNode three = ob.new TreeNode(3);
//    	TreeNode seven = ob.new TreeNode(7);
//    	
//    	root.left = four;
//    	root.right = six;
//    	six.left = three;
//    	six.right = seven;
		// output: false

    	System.out.println(ob.isValidBST(root));
	}
}
