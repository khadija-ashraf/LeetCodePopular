package hashtable.prefixSum;

import java.util.*;

public class SubArraySumEqualsK {

	
    public int subarraySum(int[] nums, int k) {
        // Brute Force: Generate every possible sub array 
    	// [Time Limit Exceeded]
    	
    	// all possible subarray: {1, -1, 2, 1, 1, -2, 2}
    	// i = 0, j = 0 
    	// (1), (1,-1), (1,-1, 2), (1, -1, 2, 1), (1,-1, 2, 1, 1), 
    	// (1,-1, 2, 1, 1, -2), (1,-1, 2, 1, 1, -2, 2)
    	
    	// i = 1, j = 1
    	// (-1), (-1, 2), (-1, 2, 1), (-1, 2, 1, 1), 
    	// (-1, 2, 1, 1, -2), (-1, 2, 1, 1, -2, 2)
    	// so on..
    	
    	int count = 0;
    	for(int i = 0; i < nums.length; i++) {
    		for(int j = i; j < nums.length; j++) {
    			int sum = 0;

    			for(int m = i; m <= j; m++) {
    				sum += nums[m];
    			}
				if(sum == k) {
					count = count + 1;
				}
    		}
    	} 
    	return count;
    }
    
    // 0, 1,-1, 2, 1, 1,-2, 2
    // 0, 1, 0, 2, 3, 4, 2, 4
    // 0, 1, 0, 1, 1, 1, 2, 2
    //
    // 1,-1,2
    // 2
    // -1,2,1
    // 2,1,1,-2
    // 1,1,-2,2
    
    // Pro-tip: The idea is to when calculating the prefix sum, in every index we 
    // ask, did we sum enough on our way that we cross by a k-sum subarray already.
    // to check this, we go k-sum-amount backwards by substracting the amount 'k' from the 
    // current index position's prefixSum, that is the currentPrefixSum.
    // 
    // then we check every index from the beginning until the current index of the 
    // prefix sum array to find any complementPrefixSum == (currentPrefixSum-k), 
    // if we find 
    // than we have got a sub array that resides between the complementPrefixSum
    // and the currentPrefixSum and this subarray is k-sum amount.
    // so, 					currentPrefixSum - complementPrefixSum = k
    // or, we can re-write, currentPrefixSum - k = complementPrefixSum
    
    public int subarraySumPrefixSum(int[] nums, int k) {
    	int[] prefixSum = new int[nums.length + 1];
    	int count = 0;
    	
    	prefixSum[0] = 1;
    	
    	for(int i = 1; i <= nums.length; i++) {
    		prefixSum[i] += prefixSum[i - 1] + nums[i-1]; // prefix-sum until position 'i'
    	}
    	
    	for(int i = 1; i <= nums.length; i++) {
    		int currentPrefixSum = prefixSum[i];
			int complementSum = currentPrefixSum - k;
			
			for(int j = 0; j < i; j++) {
				if(prefixSum[j] == complementSum) {
					count += 1;
				}
			}
    	}
    	return count;
    }
    
    public int subarraySumPrefixSumHashMap(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int count = 0;
    	
    	int currentPrefixSum = 0;
    	map.put(0, 1);
    	
    	for(int i = 0; i < nums.length; i++) {
    		currentPrefixSum += nums[i]; // prefix-sum until position 'i'
    		
    		// complementSum is a number that is 'k' less than the currentPrefixSum
    		// during our traversal of the input array the we calculated 
    		// prefixSum / running sum so far for every index. now if we find 
    		// a prefix sum in one of those previous indices which is k less than the
    		// current index prefix sum that means we just traversed a k-sum subarray
    		// that resides between the complementSum index and the currentPrefixSum index.
    		
    		// so, we can count that array as a k-sum subarray.
    		
    		// if there is any number in the map exists the complementSum, that means
    		// the complementSum can be get rid from the currentPrefixSum to achieve a 
    		// 'k'-sum subarray.
    		
    		// that means, the subarray-elements residing between
    		// the complementSum and the currentPrefixSum sums to 'k'
    		int complementSum = currentPrefixSum - k; 
    		
    		if(map.containsKey(complementSum)) {
    			count = count + map.get(complementSum);
    		}
    		map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		SubArraySumEqualsK ob = new SubArraySumEqualsK();
		
//		int[] nums = {1, -1, 2, 1, 1, 3, -1};
//		int k = 2;
//		Output: 2
		
		int[] nums = {1,2,3};
		int k = 3;
//		Output: 2
		
		System.out.println(ob.subarraySum(nums, k));
		System.out.println(ob.subarraySumPrefixSum(nums, k));
		System.out.println(ob.subarraySumPrefixSumHashMap(nums, k));
	}
}
