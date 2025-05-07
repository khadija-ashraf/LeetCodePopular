package com.leetcode;

public class RemoveDup {

	public int removeDuplicates(int[] nums) {

		if(nums.length <= 1) {
			return nums.length;
		}
		
		int k = 0;
		int i = 0;
		while(i < nums.length) {
			nums[k] = nums[i];
			k++;
			while(i < nums.length - 1 && nums[i] == nums[i+1]) {
				i++;
			}
			i++;
			
		}
		
		return k;     
	}
	
	public static void main(String[] args) {
		RemoveDup ob = new RemoveDup();
		
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println("result :: "+ob.removeDuplicates(nums));

	}

}
