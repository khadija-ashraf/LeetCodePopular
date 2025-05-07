package com.leetcode;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if(m == 0 && n > 0) {
    		for(int i = 0; i < n; i++) {
    			nums1[i] = nums2[i];
    		}
        	return;
    	}
    	
        int i = m - 1;
        int j = n - 1;
        int last = m + n - 1;

        while(i >= 0 && j >= 0) {
        	if(nums1[i] > nums2[j]) {
        		nums1[last] = nums1[i];
        		i--;
        		
        	} else {
        		nums1[last] = nums2[j];
        		j--;
        	}
        	last--;
        }
        while(j >= 0) {
        	nums1[last] = nums2[j];
        	j--;
        	last--;
        }
        
        
    }
    
    public static void main(String a[]) {
    	Solution ob = new Solution();
    	
    	int[] nums1 = {1,2,3,0,0,0};
    	int m = 3;
    	int[] nums2 = {2, 5, 6};
    	int n = 3;
    	
//    	int[] nums1 = {0};
//    	int m = 0;
//    	int[] nums2 = {1};
//    	int n = 1;
//    			
//    	int[] nums1 = {4,0,0,0,0,0};
//    	int m = 1;
//    	int[] nums2 = {1,2,3,5,6};
//    	int n = 5;
    	
//    	int[] nums1 = {0,0,0,0,0};
//    	int m = 0;
//    	int[] nums2 = {1,2,3,4,5};
//    	int n = 5;
    	
//    	int[] nums1 = {1,2,4,5,6,0};
//    	int m = 5;
//    	int[] nums2 = {3};
//    	int n = 1;
    	
    	ob.merge(nums1, m, nums2, n);
    	
    	for(int num: nums1) {
    		System.out.print(num + ", ");
    	}
    }
}
