package com.leetcode;

public class JumpGame2 {
	
	// NOTE: this is the easiest and accurate solution
//	https://www.youtube.com/watch?v=dJ7sWiOoK7g
	public int jumpGame(int[] nums) {
        if(nums.length == 0) {
        	return 0;
        }
        if (nums.length == 1) return 1;
        
        int farthest = 0;
        int left = 0;
        int right = 0;
        int jumpCnt = 0;
        
        while(right < nums.length - 1) {
        	while(left < nums.length && left <= right) {
        		farthest = Math.max(farthest, left + nums[left]);
        		left++;
        	}
        	left = right + 1;
        	right = farthest;
        	jumpCnt++;
        }
        return jumpCnt;
    }
	
	
	public static void main(String a[]) {
		JumpGame2 ob = new JumpGame2();
		
//		int[] nums = {0}; 
//		output: 0
		
//		int[] nums = {2,1}; 
//		output: 1

		int[] nums = {2,3,1,1,4};
//		output: 2

//		int[] nums = {2,3,0,1,4};
//		output: 2

		System.out.println(ob.jumpGame(nums));
	}
}
