package stack.binary;

import java.util.*;


public class BinaryTreeZigzagLevelOrder {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	if(root == null) return List.of();
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	queue.offer(root);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	int level = 0;
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		level++;
    		
    		List<Integer> aLevel = new ArrayList<Integer>();
    		
    		for(int i = 0; i < size; i++) {
        		TreeNode cur = queue.poll();
        		if(cur == null) continue;
        		
    			if(level % 2 == 1) { // left to right
    				aLevel.addLast(cur.val);
    			} else {
    				aLevel.addFirst(cur.val);
    			}

        		if(cur.left != null) queue.offer(cur.left);
        		if(cur.right != null) queue.offer(cur.right);
    		}
    		
			res.add(aLevel);
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrder ob = new BinaryTreeZigzagLevelOrder();
		
		TreeNode root = ob.new TreeNode(3);
    	TreeNode nine = ob.new TreeNode(9);
    	TreeNode twenty = ob.new TreeNode(20);
    	TreeNode fifteen = ob.new TreeNode(15);
    	TreeNode seven = ob.new TreeNode(7);
    	
    	root.left = nine;
    	root.right = twenty;
    	twenty.left = fifteen;
    	twenty.right = seven;
    	
    	System.out.println(ob.zigzagLevelOrder(root));
    	
	}

}
