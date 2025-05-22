package hashtable.prefixSum;

import java.util.*;

public class SubArraySumDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
		int count = 0;
		int currentPrefixSum = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0,  1);
    	for(int i = 0; i < nums.length; i++) {
    		currentPrefixSum += nums[i];
    		//handle negative values. 
    		int complementPrefixSum = (currentPrefixSum % k + k) % k;
    		
    		if(map.containsKey(complementPrefixSum)) {
    			count = count + map.get(complementPrefixSum);
    		}
    		
    		map.put(complementPrefixSum, map.getOrDefault(complementPrefixSum, 0) + 1);
    	}
        return count;
    }
    
	public static void main(String[] args) {
		SubArraySumDivisibleByK ob = new SubArraySumDivisibleByK();
		
		// index : 0,1,2,  3, 4, 5,6
		// input : 0,4,5,  0,-2,-3,1
		// prefix: 0,4,9,  9, 7, 4,5
	// complement: 0,4,4,  4, 2, 4,0
		
	
		int[] nums = {4,5,0,-2,-3,1};
		int k = 5;
//		Output: 7
		
		// index : 0, 0,1,2
		// input : 0,-1,2,9
		// prefix: 0,-1,1,10
	// complement: 0, 1,1,0
//		output: 2
		
		// (-1+1+10) = 10 % 5 == 0
		// (10) = 10 % 5 == 0
		
//		int[] nums = {-1,2,9};
//		int k = 2;
		
		System.out.println(ob.subarraysDivByK(nums, k));

	}

}
