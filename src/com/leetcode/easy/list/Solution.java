package com.leetcode.easy.list;

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

public class Solution {
	public int[] productExceptSelf(int[] nums) {
        // left to right multiplication
        int prev = 1;
        for(int i = 0; i < nums.length; i++) {
        	int temp = nums[i];
        	nums[i] = prev;
        	prev *= temp;
        }
        
//        1,		1,		1*2,		1*2*3 
//        2*3*4 	1*3*4	1*2*4		1*2*3
        // right to left multiplication
        prev = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
        	nums[i] = nums[i] * prev;
        	prev = nums[i];
        }
        
        for(int i = 0; i < nums.length; i++) {
        	System.out.println(nums[i]);
        }
        return nums;
    }
	public static void main(String[] args) {
		Solution ob = new Solution();
		int[] nums = {1,2,3,4};
		ob.productExceptSelf(nums);
	}
	
//	public int climbStairs1(int n) {
//        if(n == 0) return 1;
//        if(n < 0) return 0;
//        
//        return climbStairs(n-1) + climbStairs(n-2);
//    }
//	
//	public int climbStairs(int n) {
//		if(n <= 2) return n;
//        int[] dp = new int[n+1];
//        
//        // dp[i] = number of ways to reach to i'th step.
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;
//        
//        for(int i = 3; i <= n; i++) {
//        	dp[i] = dp[i - 1] + dp[i -2];
//        }
//        return dp[n];
//    }

	
//	public int mySqrt(int x) {
//	int res = 0;
//	int left = 0;
//	int right = x;
//	
//	while(left <= right) {
//		int mid = left + (right - left)/2;
//		
//		if((mid * mid) > x) {
//			right = mid - 1;
//		} else if((mid * mid) < x){
//			left = mid + 1;
//			res = mid;
//		} else {
//			return mid;
//		}
//	}
//	return res;
//}

	
//	public boolean isPalindrome(int x) {
//	
////		x = 121
////		121%10 = 1 (right digit)
////		121 / 100 = 1 (left digit)
////	if left == right continue
////	121 % 100 = 21
////	21 / 10 = 2 = x
////	repeat
//	
//	if(x < 0) return false;
//	
//	if(x >= 0 && x <= 9) return true;
//	
//	int divisor = 1;
//	// keep multiplying the divisor until the divisor becomes enough big 
//	// so that divisor can divide 'x' and find the lest most digit. 
//	while(true) {
//		int quotient = x / divisor;
//		
//		if(quotient >= 0 && quotient <= 9)
//			break;
//		else divisor *= 10;
//	}
//	
//	while(x != 0) {
//		int right = x % 10;
//		int left = x / divisor;
//		
//		if(left != right) return false;
//		
//		int temp = x % divisor;
//		int nextX = temp / 10;
//		
//		x = nextX;
//		divisor = divisor / 100;
//	}
//	return true;
//    
//}

	
//	public int reverseBits(int n) {
//  int res = 0;
//  
//  for(int i = 0; i < 32; i++) {
//  	int bit = (n >> i) & 1;
//  	res = res | (bit << 31 - i);
//  }
//  return res;
//}

	
//	private Integer prev = null;
//	private int minDiff = Integer.MAX_VALUE;
//	
//    public int getMinimumDifference(TreeNode root) {
//    	inorder(root);
//    	return minDiff;
//    }
//    private void inorder(TreeNode root) {
//    	if(root == null) return;
//    	
//    	inorder(root.left);
//    	
//    	if(prev != null) {
//    		minDiff = Math.min(minDiff, Math.abs(root.val - prev));
//    	}
//    	prev = root.val;
//    	
//    	inorder(root.right);
//    }


//	public List<Double> averageOfLevels(TreeNode root) {
//	if(root == null) return null;
//	
//    Queue<TreeNode> queue = new LinkedList<>();
//    List<Double> res = new ArrayList<Double>();
//    
//    queue.add(root);
//    
//    while(!queue.isEmpty()) {
//    	int queueSize = queue.size();
//    	double sum = 0;
//    	for(int i = 0; i < queueSize; i++) {
//        	TreeNode current = queue.poll();
//        	sum += current.val;
//        	
//        	if(current.left != null)
//        		queue.add(current.left);
//        	if(current.right != null)
//        		queue.add(current.right);
//    	}
//    	double avg = sum / queueSize;
//    	res.add(avg);
//    }
//    return res;
//}

	
//	public int countNodes(TreeNode root) {
//  if(root == null) return 0;
//  
//  return 1 + countNodes(root.left) + countNodes(root.right);
//}

	
//  public boolean hasPathSum(TreeNode root, int targetSum) {
//	if(root == null) {
//		return false;
//	}
//	
//    if(targetSum == root.val && root.left == null && root.right == null) {
//    	return true;
//    }
//    
//    return hasPathSum(root.left, targetSum - root.val) ||
//    		hasPathSum(root.right, targetSum - root.val);
//}

	
//	public boolean isSymmetric(TreeNode root) {
//  if(root == null) return true;
//  
//  return checkSymmetry(root.left, root.right);
//  
//}
//
//public boolean checkSymmetry(TreeNode t1, TreeNode t2) {
//	if(t1 == null && t2 == null) return true;
//	if(t1 == null || t2 == null) return false;
//	
//	return (t1.val == t2.val)
//			&& checkSymmetry(t1.left, t2.right)
//			&& checkSymmetry(t1.right, t2.left);
//}

//	public TreeNode invertTree(TreeNode root) {
//	if(root == null) {
//		return null;
//	}
//	TreeNode temp = root.left;
//	root.left = invertTree(root.right);
//	root.right = invertTree(temp);
//	
//	return root;
//}

	
//	public String reverseStr(String s, int k) {
//		char[] sArr = s.toCharArray();
//        for(int i = 0; i < sArr.length; i++) {
//        	int remaining = sArr.length - i;
//
//        	if (remaining < k) {
//            	int l = i;
//            	int r = sArr.length - 1;
//
//        		reverse(sArr, l, r);
//            	break;
//
//        	} else if(remaining < 2  k && remaining >= k) {
//            	int l = i;
//            	int r = i + k - 1;
//            	reverse(sArr, l, r);
//
//            	break;
//            	
//        	} else {
//        		int l = i;
//            	int r = i + k - 1;
//
//        		reverse(sArr, l, r);
//            	i = (i + k - 1) + k;
//        	}
//        }
//        return new String(sArr);
//    }
//	
//	public void reverse(char[] sArr, int l, int r) {
//		while(l < r) {
//    		char temp = sArr[l];
//    		sArr[l] = sArr[r];
//    		sArr[r] = temp;
//    		
//    		l++;
//    		r--;
//    	}
//	}

//	public boolean isPalindrome(ListNode head) {
//	if(head == null) return false;
//	
//	if(head.next == null) return true;
//	
//    // find the middle with slow, fast pointer
//	ListNode slow = head, fast = head;
//	
//	int count = 0;
//	ListNode prevOfMid = null;
//	while(fast != null && fast.next != null) {
//		count++;
//		prevOfMid = slow;
//		slow = slow.next;
//		fast = fast.next.next;
//	}
//	
//	 
////	1	2	3	4	5
////			s 
////					f
//
////	1	2	3	4	5	6
////				s 
////						f
//	// break the list into two halves
//	ListNode tempHead = slow;
//	
//	// reverse the last half
//	ListNode prev = null;
//	ListNode current = tempHead;
//	
//	while(current != null) {
//		ListNode next = current.next;
//		current.next = prev;
//		prev = current;
//		current = next;
//	}
//	
//	// reversed list's head;
//	ListNode head2 = prev;
//	
//	// now traverse both lists simultaneously and check if every node value pair is equal 
//	ListNode c1 = head;
//	ListNode c2 = head2;
//	
//	// Since we are traversing both the halves simultaneously therefore odd length input strings 
//	// will also be handles automatically.
//	// because we only traverse the even half and the remaining one single element  will not be matched.
//	while(c1 != null && c2 != null) {
//		if(c1.val != c2.val) {
//			return false;
//		}
//		c1 = c1.next;
//		c2 = c2.next;
//	}
//	return true;
//	
//}

	
//	public boolean isHappy(int n) {
//
//		if(n == 0) return false;
//		
//		Set<Integer> set = new HashSet<>();
//    	int num = n;
//
//        while(!set.contains(num)) {
//        	set.add(num);
//        	int local = 0;
//        	
//        	// find the digit square
//        	while(num != 0) {
//        		int remainder = num % 10;
//        		local += (remainder * remainder);
//        		
//        		int quotient = num / 10;
//        		num = quotient;
//        	}
//        	System.out.println(local);
//        	if(local == 1) return true;
//        	else num = local;
//        }
//        return false;
//    }

	
	
//	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode a = headA;
//        ListNode b = headB;
//        
//        while(a != b) {
//        	if(a == null) {
//        		a = headB;
//        	} else {
//        		a = a.next;
//        	}
//        	if(b == null) {
//        		b = headA;
//        	}else {
//        		b = b.next;
//        	}
//        }
//        return a;
//    }


}
