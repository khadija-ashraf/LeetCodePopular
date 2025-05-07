package stack.binary;

import java.util.*;

public class SumRootToLeafNumbers {
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
	
	class NodeLevel{
		TreeNode node;
		int level;

		NodeLevel(){}
		
		NodeLevel(TreeNode node, int level){
			this.node = node;
			this.level = level;
		}
	}
	
	public int sumNumbers(TreeNode root) {
		List<List<Integer>> allPath = dfs(root);
		
		System.out.println(allPath);
		int totalSum = 0;
		
		for(List<Integer> alist: allPath) {
			int decimalPlace = alist.size() - 1 ;
			int sum = 0;
			
			for(int n: alist) {
				sum += (n * Math.pow(10, decimalPlace));
				decimalPlace--;
			}
			totalSum += sum;
		}
		return totalSum;
    }
    
	public List<List<Integer>> dfs(TreeNode root) {
        if(root == null) return List.of();
        
        if(root.left == null && root.right == null) {
        	return List.of(List.of(root.val));
        }
        
        List<List<Integer>> left = dfs(root.left);
        List<List<Integer>> right = dfs(root.right);
        
        List<List<Integer>> allPath = new ArrayList<>();
        
        for(List<Integer> aList: left) {
        	List<Integer> temp = new ArrayList<Integer>();
        	temp.add(root.val);
        	temp.addAll(aList);
        	allPath.add(temp);
        }
        
        for(List<Integer> aList: right) {
        	List<Integer> temp = new ArrayList<Integer>();
        	temp.add(root.val);
        	temp.addAll(aList);
        	allPath.add(temp);
        }
        return allPath;
	}
	
	public static void main(String[] args) {
		SumRootToLeafNumbers ob = new SumRootToLeafNumbers();
		
		TreeNode root = ob.new TreeNode(1);
    	TreeNode two = ob.new TreeNode(2);
    	TreeNode three = ob.new TreeNode(3);
    	
    	root.left = two;
    	root.right = three;
    	
    	System.out.println(ob.sumNumbers(root));
	}

}
