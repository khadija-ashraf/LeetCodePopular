package hashtable.twoSum;

import java.util.*;

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
public class TwoSum4 {
	
	// Time: O(n)
	// Space: O(2n)= O(n) for the set + dfs recursion stack
    public boolean findTargetDFSnHashset(TreeNode root, int k) {
    	Set<Integer> set = new HashSet<>();
    	
    	return dfs(root, k, set);
    }
    
    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
    	if(root == null) return false;
    	
    	if(set.contains(k - root.val)) return true;
    	
    	set.add(root.val);
    	
    	return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
    
	//	Time: O(n) inorder + O(n) two pinter = O(2n) = O(n)
    //  Space: O(n) for the sorted list + O(n) inorder-dfs recursion stack = O(2n) = O(n)
    public boolean findTargetInOrderNTwoPointer(TreeNode root, int k) {
    	// sort the input BST using inorder traversal (left->root->right)
    	List<Integer> nums = inorderTravarsal(root); 
    	
    	// use two pointer in this sorted list to find the the target sum.
    	// this two pointer technique is exact implementation of the 
    	// leetcode 167. Two Sum II - Input Array Is Sorted
    	
    	int left = 0;
    	int right = nums.size() - 1;
    	
    	while(left < right) {
        	int sum = nums.get(left) + nums.get(right);
        	
        	if(sum < k) {
        		left++;
        	} else if (sum > k) {
        		right--;
        	} else {
        		return true;
        	}
        }
    	return false;
    }
    
    private List<Integer> inorderTravarsal(TreeNode root) {
    	if(root == null) return List.of();
    	
    	List<Integer> sorted = new ArrayList<Integer>();
    	
    	List<Integer> left = inorderTravarsal(root.left);
    	sorted.addAll(left);
    	
    	sorted.add(root.val);
    	
    	List<Integer> right = inorderTravarsal(root.right);
    	sorted.addAll(right);

    	return sorted;
    }
    
	public static void main(String[] args) {
		TwoSum4 ob = new TwoSum4();
//		int[] root = {5,3,6,2,4,null,7};
		int k = 14;
//		
		TreeNode root = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode seven = new TreeNode(7);

		root.left = three;
		root.right = six;
		
		three.left = two;
		three.right = four;
		
		six.right = seven;
//		Output: true
		
		//--------------
		
//		int[] root = [2,1,3];
//		int k = 4;
//		
//		TreeNode root = new TreeNode(2);
//		TreeNode three = new TreeNode(3);
//		TreeNode one = new TreeNode(1);
//
//		root.left = one;
//		root.right = three;
//		
//		Output: true
		
		System.out.println(ob.findTargetDFSnHashset(root, k));
		System.out.println(ob.findTargetInOrderNTwoPointer(root, k));

	}

}
