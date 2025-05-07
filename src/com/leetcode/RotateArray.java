package com.leetcode;

public class RotateArray {
	public void rotateRight(int[] nums, int k) {
        // Step 1: Reverse entire array
		// step 2: Reverse first k items
		// step 3: reverse rest of the k-1 elements
		// 1,2,3,4,5,6,7 ; k = 3
		// 7,6,5,4,3,2,1
		// 5, 6, 7, 4, 3, 2, 1
		// 5, 6, 7, 1, 2, 3, 4
		
		int n = nums.length;
		
		if(k > n) k = k % n;

		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
		
		for(int num: nums) {
    		System.out.print(num + ", ");
    	}
    }
	
	public void reverse(int[] nums, int left, int right) {
		if(left >= right) return;
		
		while(left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		RotateArray ob = new RotateArray();
		
//		int[] nums = {1,2,3,4,5,6,7}; 
//		int k = 10;
		
		int[] nums = {1,2}; 
		int k = 3;
		
		ob.rotateRight(nums, k);

	}

}
