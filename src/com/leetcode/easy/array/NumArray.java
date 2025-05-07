package com.leetcode.easy.array;

public class NumArray {

    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
    	int sum = 0;
        while(left <= right) {
        	sum += nums[left];
        	left++;
        }
        return sum;
    }
    
    public static void main(String a[]) {
    	
    	int[] nums = {-2, 0, 3, -5, 2, -1};
    	
    	NumArray numArray = new NumArray(nums);
    	System.out.println(numArray.sumRange(0, 2));
    	System.out.println(numArray.sumRange(2, 5));
    	System.out.println(numArray.sumRange(0, 5));
//    	numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
//    	numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
//    	numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */