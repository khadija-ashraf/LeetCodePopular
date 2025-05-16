package hashtable.twoSum;

import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        if(nums.length <= 0) return new int[] {0,0};
        
        int[] res = new int[2];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
        	
        	int pair = target - nums[i];
        	
        	if(map.containsKey(pair)) {
        		res[0] = map.get(pair);
        		res[1] = i;
        		return res;
        	}
        	map.putIfAbsent(nums[i], i);
        }
        return res;
	}
	public static void main(String[] args) {
		TwoSum ob = new TwoSum();
		
		int[] nums = {2,7,11,15};
		int target = 9;
		
//		Output: [0,1]
		
		ob.twoSum(nums, target);
	}

}
