package stack.binary;

import java.util.Stack;


public class FlattenBinaryTreeToLinkedList {
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
	
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) return;
        
        TreeNode dummyhead = new TreeNode(0);
        dummyhead = root;
        TreeNode tail = dummyhead;
        
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, false));
        
        while(!stack.isEmpty()) {
        	State cur = stack.pop();
        	
        	if(cur.node == null) continue;
        	
        	if(cur.visited) {
        		tail.right = cur.node;
        		tail.left = null;
        		tail = tail.right;
        	} else {
        		if(cur.node.right != null) stack.push(new State(cur.node.right, false));
        		if(cur.node.left != null) stack.push(new State(cur.node.left, false));
        		stack.push(new State(cur.node, true));
        	}
        }
        
        TreeNode cur = dummyhead;
    	
    	while(cur != null) {
    		System.out.println(cur.val);
    		cur = cur.right;
    	}
        root = dummyhead;
    }
    
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList ob = new FlattenBinaryTreeToLinkedList();
				
		TreeNode root = ob.new TreeNode(1);
    	TreeNode two = ob.new TreeNode(2);
    	TreeNode three = ob.new TreeNode(3);
    	TreeNode four = ob.new TreeNode(4);
    	TreeNode five = ob.new TreeNode(5);
    	TreeNode six = ob.new TreeNode(6);
    	
    	root.left = two;
    	root.right = five;
    	two.left = three;
    	two.right = four;
    	five.right = six;
    	
    	ob.flatten(root);
    	
    	TreeNode cur = root;
    	
//    	while(cur != null) {
//    		System.out.println(cur.val);
//    		cur = cur.right;
//    	}
	}
}
