package com.leetcode;

public class RemoveDup2 {
	public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
        	return 0;
        }
        
        int k = 0; 
        int i = 0;
        
        while(i < nums.length && k < nums.length) {
        	nums[k] = nums[i];
        	k++;
        	int dupCnt = 0;
        	while(i < nums.length - 1 && nums[i] == nums[i+1]) {
        		i++;
        		dupCnt++;
        	}
        	if(dupCnt > 0) {
        		nums[k] = nums[i];
            	k++;
        	}
        	i++;
        }
        return k;
    }
	
	
	public static void main(String[] args) {
		RemoveDup2 ob = new RemoveDup2();
		
//		int[] nums = {1,1,1,2,2,3};
//		int[] nums = {0,0,1,1,1,1,2,3,3};
		int[] nums = {};
		
		System.out.println("result :: "+ob.removeDuplicates(nums));

	}
}
