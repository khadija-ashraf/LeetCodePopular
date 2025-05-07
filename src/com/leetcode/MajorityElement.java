package com.leetcode;

public class MajorityElement {
	
	// Note: the concept is the majority element count will be more than 
	// half of the elements in the array.  so take an element as a candidate
	// and increment a count when we get that same element in the array.
	// if the next element does not match we decrease the count, if the 
	// element matches with the candidate we increase the count. 
	// this is like keep crossing when we find mismatch. The last candidate 
	// will be the majority element because at most half of the elements
	// will be crossed over by other elements but since the majority element 
	// count cumulatively higher than half of the array to it will stick around.
	// and the count will be >= 1 for that particular candidate.
	
	
	public int majorityElement(int[] nums) {
		if(nums.length <= 0)
			return 0;
		
		int count = 0;
		int candidate = 0;
        
		for(int i = 0; i < nums.length; i++) {
			if(count == 0) {
				candidate = nums[i];
				count++;
				continue;
			}
			if(nums[i] != candidate) {
				count -= 1;
			} else {
				count += 1;
			}
		}
		return candidate;
    }

//	nums = [2,2,1,1,1,2,2]
	
	public static void main(String[] args) {
//		int[] nums = {2,2,1,1,1,2,2};
		int[] nums = {3,2,3};
//		int[] nums = {3,3,4};
		
		MajorityElement ob = new MajorityElement();
		
		System.out.println(ob.majorityElement(nums));
		
	}

}
