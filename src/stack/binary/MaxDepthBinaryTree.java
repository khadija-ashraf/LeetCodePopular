package stack.binary;

import java.util.Stack;

public class MaxDepthBinaryTree {
	
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
		int depth;
		
		NodeTuple(){};
		NodeTuple(TreeNode node, int depth){
			this.node = node;
			this.depth = depth;
		}
	}
	public int maxDepthIterative(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int max = Integer.MIN_VALUE;
        
        Stack<NodeTuple> stack = new Stack<>();
        stack.push(new NodeTuple(root, 1));
        
        while(!stack.isEmpty()) {
        	NodeTuple cur = stack.pop();
        	
        	if(cur.node.right != null) {
        		stack.push(new NodeTuple(cur.node.right, cur.depth + 1));
        		max = Math.max(max, cur.depth + 1);
        	}
        	
        	if(cur.node.left != null) {
        		stack.push(new NodeTuple(cur.node.left, cur.depth + 1));
        		max = Math.max(max, cur.depth + 1);
        	}
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
	
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
	public static void main(String a[]) {
		MaxDepthBinaryTree ob = new MaxDepthBinaryTree();
		TreeNode root = ob.new TreeNode(1);
    	TreeNode two = ob.new TreeNode(2);
    	TreeNode three = ob.new TreeNode(3);
    	TreeNode five = ob.new TreeNode(5);
    	
    	root.left = two;
    	root.right = three;
    	two.right = five;
    	
    	System.out.println(ob.maxDepth(root));
    	System.out.println(ob.maxDepthIterative(root));
	}
}
