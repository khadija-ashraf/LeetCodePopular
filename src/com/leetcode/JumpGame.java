package com.leetcode;

public class JumpGame {
	
	public boolean canJump(int[] nums) {
		int goal = nums.length - 1;
		
		int i = nums.length - 2;
		
		while(i >= 0) {
			if(i + nums[i] >= goal) {
				goal = i;
			}
			i--;
		}
		return goal == 0;
        
    }
	
	public static void main(String a[]) {
		JumpGame ob = new JumpGame();
		
//		int[] nums = {2,3,1,1,4};
		int[] nums = {3,2,1,0,4};
		
		System.out.println(ob.canJump(nums));
	}
}
