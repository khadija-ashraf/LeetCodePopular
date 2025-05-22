package hashtable.prefixSum;

import java.util.*;

public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
    	int count = 0;
    	for(int i = 0; i < nums.length; i++) {
			int sum = 0;
    		for(int j = i; j < nums.length; j++) {
    			sum += nums[j];
				if(sum == k) {
					count = count + 1;
				}
    		}
    	} 
    	return count;
    }
    
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
		
		int[] nums = {1, -1, 2, 1, 1, 3, -1};
		int k = 2;
//		Output: 5
		
//		int[] nums = {1,2,3};
//		int k = 3;
//		Output: 2
		
		System.out.println(ob.subarraySum(nums, k));
		System.out.println(ob.subarraySumPrefixSum(nums, k));
		System.out.println(ob.subarraySumPrefixSumHashMap(nums, k));
	}
}
