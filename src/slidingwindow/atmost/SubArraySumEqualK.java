package slidingwindow.atmost;

public class SubArraySumEqualK {
//	 Why the “atMost(k) - atMost(k - 1)” pattern doesn’t apply here:
//
//		 This technique works when:
//		 	1.	Subarray counts are monotonic with respect to some property — like number of 1s or number of distinct elements.
//		 	2.	The array satisfies a constraint like:
//		 	•	All elements are non-negative (e.g., Binary array or positive integers)
//		 	•	Sliding window sum or property grows/shrinks predictably
//
//		 ⸻
//
//		 ❌ Why not here?
//
//		 In LC 560, the array can have negative numbers, so:
//		 	•	The subarray sum is not monotonic
//		 	•	A larger window may not have a larger sum
//		 	•	So sliding window with atMost(k) is not reliable — the window could “skip” a valid subarray
//
//		 ⸻
//
//		 ✅ When atMost works
//
//		 In problems like LC 930, the array only has 0 and 1, so sum is always non-decreasing as window grows → “atMost” logic applies.
    public int subarraySum(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
    	int left = 0;
    	int right = 0;
    	int sum = 0;
    	int count = 0;
    	
    	while(right < nums.length) {
    		sum += nums[right];
    		
    		while(sum > k) {
    			sum -= nums[left];
    			left++;
    		}
    		
    		count += right - left + 1;
    		right++;
    	}
    	return count;
    }
	public static void main(String[] args) {
		SubArraySumEqualK ob = new SubArraySumEqualK();
//		int[] nums = {1,1,1};
//		int k = 2;
		
//		Output: 2

//		int[] nums = {1,2,3};
//		int k = 3;
//		Output: 2
				
		int[] nums = {-1,-1,1};
		int k = 0;
		
		System.out.println(ob.subarraySum(nums, k));
	}

}
